import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EngineTest {
    @Test
    public void checkThatEngineClassImplementsCloneable() {
        String cloneableInterface = "java.lang.Cloneable";
        List<Type> interfaces = Arrays.asList(Engine.class.getGenericInterfaces());
        interfaces.stream()
                .filter(i -> i.getTypeName().equals(cloneableInterface))
                .findFirst().orElseThrow(() -> new RuntimeException("Class Engine should implement interface Cloneable"));
    }

    @Test
    public void checkEngineFieldsCount() {
        List<Field> privateFields = new ArrayList<>();
        List<Field> allFields = Arrays.asList(Engine.class.getDeclaredFields());
        for (Field field : allFields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                privateFields.add(field);
            }
        }

        Assert.assertEquals("You should have private fields only!", allFields.size(), privateFields.size());
        Assert.assertTrue("You should have at least 5 fields in the Engine.class", privateFields.size() >= 5);
    }

    @Test
    public void checkThatMethodCloneExists() {
        List<Method> carMethods = Arrays.asList(Engine.class.getDeclaredMethods());
        carMethods.stream()
                .filter(m -> m.getName().equals("clone"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Method clone should be present in the Engine.class"));
    }
}