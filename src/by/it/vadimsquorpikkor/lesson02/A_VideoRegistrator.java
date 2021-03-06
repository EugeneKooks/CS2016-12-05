package by.it.vadimsquorpikkor.lesson02;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class A_VideoRegistrator {

    double start;
    double end;
    int count;

    public static void main(String[] args) {
        A_VideoRegistrator instance=new A_VideoRegistrator();
        double[] events=new double[]{1, 1.1, 1.6, 2.2, 2.4, 2.7, 3.9, 8.1, 9.1, 5.5, 3.7};
        List<Double> starts=instance.calcStartTimes(events,1); //рассчитаем моменты старта, с длинной сеанса 1
        System.out.println(starts);                            //покажем моменты старта
    }
    //модификаторы доступа опущены для возможности тестирования
    List<Double> calcStartTimes(double[] events, double workDuration){
        //events - события которые нужно зарегистрировать
        //timeWorkDuration время работы видеокамеры после старта
        List<Double> result;
        result = new ArrayList<>();
        int i=0;                              //i - это индекс события events[i]
        //комментарии от проверочного решения сохранены для подсказки, но вы можете их удалить.
                                              //подготовка к жадному поглощению массива событий
                                              //hint: сортировка Arrays.sort обеспечит скорость алгоритма
                                              //C*(n log n) + C1*n = O(n log n)

                                              //пока есть незарегистрированные события
                                                //получим одно событие по левому краю
                                                //и запомним время старта видеокамеры
                                                //вычислим момент окончания работы видеокамеры
                                                //и теперь пропустим все покрываемые события
                                                //за время до конца работы, увеличивая индекс

        Arrays.sort(events);

        start = events[0];
        end=start+1;
        count = 1;
        printStep();
        result.add(start);

        for (double d : events) {
            if (d > end) {
                start=d;
                end=start+1;
                count++;
                printStep();
                result.add(start);
            }
        }

        return result;                        //вернем итог
    }

    void printStep() {
        System.out.println("step" + count + ": start - " + start + " ,end - " + (start+1));
    }
}
