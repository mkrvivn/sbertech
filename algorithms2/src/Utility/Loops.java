package Utility;

import java.util.function.Consumer;

public class Loops {
    public static void times(int n, Iteration task)
    {
        for(int i = 0; i < n; i++)
            task.iter(i);
    }
}
