import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CarTest {
    @Test
    public void checkThatCarImplementsCloneable() {
        String cloneableInterface = "java.lang.Cloneable";
        List<Type> interfaces = Arrays.asList(Car.class.getGenericInterfaces());
        interfaces.stream()
                .filter(i -> i.getTypeName().equals(cloneableInterface))
                .findFirst().orElseThrow(() -> new RuntimeException("Class Car should implement interface Cloneable"));
    }

    @Test
    public void checkCarFieldsCount() {
        List<Field> privateFields = new ArrayList<>();
        List<Field> allFields = Arrays.asList(Car.class.getDeclaredFields());
        for (Field field : allFields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                privateFields.add(field);
            }
        }

        Assert.assertEquals("You should have private fields only!", allFields.size(), privateFields.size());
        Assert.assertTrue("You should have at least 5 fields in the Car.class", privateFields.size() >= 5);
    }

    @Test
    public void checkEngineExistsInCar() {
        List<Field> allFields = Arrays.asList(Car.class.getDeclaredFields());
        Optional<Field> engine = allFields.stream()
                .filter(f -> f.getGenericType().getTypeName().endsWith("Engine"))
                .findAny();
        Assert.assertTrue("You should use Engine in your car", engine.isPresent());
    }

    @Test
    public void checkThatMethodCloneExists() {
        List<Method> carMethods = Arrays.asList(Car.class.getDeclaredMethods());
        carMethods.stream()
                .filter(m -> m.getName().equals("clone"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Method clone should be present in the Car.class"));
    }
}