package test.epam.task1.integration;

import com.epam.task1.configurator.RepositoryConfigurator;
import com.epam.task1.configurator.WarehouseConfigurator;
import com.epam.task1.entity.CustomArray;
import com.epam.task1.entity.CustomArrayParameters;
import com.epam.task1.entity.Warehouse;
import com.epam.task1.exception.CustomArrayException;
import com.epam.task1.observer.CustomArrayObserver;
import com.epam.task1.observer.impl.CustomArrayObserverImpl;
import com.epam.task1.repository.Repository;
import com.epam.task1.service.ArrayChangeService;
import com.epam.task1.service.ArrayFindService;
import com.epam.task1.service.impl.ArrayChangeServiceImpl;
import com.epam.task1.service.impl.ArrayFindServiceImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.*;

import static org.testng.Assert.*;

public class IntegrationTest {
    private static final String DATA_FILE_NAME;

    static {
        String fileSimpleName = "arraysFile.txt";
        ClassLoader loader = IntegrationTest.class.getClassLoader();
        URL fileURI = loader.getResource(fileSimpleName);
        if (fileURI == null) {
            fail("Test failed, because file " + fileSimpleName + " not found.");
        }
        DATA_FILE_NAME = fileURI.toString().substring(6);
    }

    @DataProvider(name = "data")
    public Object[][] configureData() {
        RepositoryConfigurator repositoryConfigurator = new RepositoryConfigurator();
        Repository repository = repositoryConfigurator.configure(DATA_FILE_NAME);
        CustomArrayObserver observer = new CustomArrayObserverImpl();
        repository.forEach((x) -> x.attach(observer));
        WarehouseConfigurator warehouseConfigurator = new WarehouseConfigurator();
        Warehouse warehouse = warehouseConfigurator.configure(repository.getAll());
        Object[][] data = new Object[1][2];
        data[0] = new Object[]{
                repository,
                warehouse
        };
        return data;
    }

    @Test(dataProvider = "data")
    public void testRepositoryAndWarehouseSize(Repository repository, Warehouse warehouse) {
        assertEquals(warehouse.getIdSet().size(), repository.size());
    }

    @Test(dataProvider = "data")
    public void testRepositoryAndWarehouseId(Repository repository, Warehouse warehouse) {
        Set<Integer> repositoryIdSet = generateIdSet(repository);
        Set<Integer> warehouseIdSet = warehouse.getIdSet();
        assertEquals(repositoryIdSet, warehouseIdSet);
    }

    private Set<Integer> generateIdSet(Repository repository) {
        Set<Integer> idSet = new HashSet<>();
        List<CustomArray> arrays = repository.getAll();
        for(CustomArray array : arrays){
            idSet.add(array.getId());
        }
        return idSet;
    }

    @Test(dataProvider = "data")
    public void testChangeArray(Repository repository, Warehouse warehouse) {
        CustomArray array = repository.get(0);
        CustomArray arrayClone;
        try {
            arrayClone = array.clone();
            ArrayChangeService changeService = new ArrayChangeServiceImpl();
            final int value = 1;
            final int replacement = 10000;
            changeService.replaceAll(arrayClone, value, replacement);
            Map<Integer, CustomArrayParameters> expectedParamsMap = warehouse.getParams();
            updateParams(expectedParamsMap, arrayClone);
            changeService.replaceAll(array, value, replacement);
            Map<Integer, CustomArrayParameters> actualParamsMap = warehouse.getParams();
            assertNotSame(expectedParamsMap, actualParamsMap, "Test failed. Params map are same.");
            assertEquals(expectedParamsMap, actualParamsMap);
        } catch (CloneNotSupportedException exception) {
            fail("Test failed. Array clone not created", exception);
        } catch (CustomArrayException customArrayException) {
            fail("Test failed. Array not changed. ", customArrayException);
        }
    }

    private void updateParams(Map<Integer, CustomArrayParameters> params, CustomArray array) {
        Integer id = array.getId();
        ArrayFindService findService = new ArrayFindServiceImpl();
        try {
            OptionalInt max = findService.findMax(array);
            OptionalInt min = findService.findMin(array);
            int sum = findService.findSum(array);
            OptionalDouble average = findService.findAverage(array);
            params.put(id, new CustomArrayParameters(max, min, sum, average));
        } catch (CustomArrayException customArrayException) {
            fail("Params not calculated", customArrayException);
        }
    }
}
