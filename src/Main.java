import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);//сканнер
        System.out.println("Сколько будет создано треугольников?");
        int n=3*sc.nextInt();//кол-во точек
        double max;//для посика точки с наибольшей координатой по Оу
        int k=0;//для запоминания индесов
        double min;//для поиска минимума

        Point[] arr=new Point[n];//наши объекты
        arr[0]=new Point(sc.nextDouble(),sc.nextDouble());//первая точка
        max=arr[0].getY();
        System.out.println("1) "+arr[0]);//ее вывод

        for(int i=1;i<n;i++){//цикл по заполнению массива объектов
            arr[i]=new Point(sc.nextDouble(), sc.nextDouble());//считали точку
            if (max<arr[i].getY()){
                max=arr[i].getY();           }
            System.out.println(i+1+") "+arr[i]);
        }
        min=max;

        int[] x=new int[n];//цикл по заполнению массива "х" индесами из массива объектов
        for(int i=0;i<n;i++){//в итоге он будет заполнен индексами по порядку, то есть если a1(индекс)>a2, то у точки
            for(int j=0;j<n;j++){//в массиве с индексом x[а1] координата по Оy> чем у точки в массиве с индексом x[а2]
                if (arr[j].getY()<=min&&arr[j].getFlg()){//поиск минимума по Оу (точка должна быть еще не рассмотрена)
                    min=arr[j].getY();
                    k=j;
                }
            }
            min=max;//нашли, обнулили счетчик
            arr[k].del();//закрыли точка для дальнейшего просмотра
            x[i]=k;//заполнили массив х
        }

        Triangle tri=new Triangle();//создали дефолтный треугольник
        for(int i=0;i<n;){//вывод наших искомых треугольников
            tri=new Triangle(arr[x[i]],arr[x[i+1]],arr[x[i+2]]);//I-тый треугольник, состоит из точек, у которых координаты по Оу>=
            System.out.println(tri);//больше чем у точки с индексом x[i-1] и <= x[i+4]
            i=i+3;
        }
    }
}