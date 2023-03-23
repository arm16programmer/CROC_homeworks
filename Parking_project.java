import java.util.ArrayList;
import java.util.Scanner;

/** Главный класс, в котором объявляется массив припаркованных автомобилей, дается выбор действия пользователю
 *
 */
public class Parking_project {

   private static int totalPlaces;
   private static int availablePlaces;
   private static int entrance;
   private static int exit;



   int[] parkedCars = new int[10];


   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      System.out.println("Введите общее количество мест на парковке: ");
      totalPlaces = sc.nextInt();
      availablePlaces = totalPlaces;

      while (true) {
         System.out.println("\nЧто Вы хотите сделать?");
         System.out.println("1) Припарковать машину");
         System.out.println("2) Узнать количество свободных мест");
         System.out.println("3) Узнать список машин, проехавших через указанный въезд");
         System.out.println("4) Узнать список машин, проехавших через указанный выезд");
         System.out.println("5) Узнать список попыток, когда машина не смогла попасть на парковку");
         System.out.println("6) Въехать через выезд №1");
         System.out.println("7) Въехать через выезд №2");
         System.out.println("8) Выехать через выезд №1");
         System.out.println("9) Выехать через выезд №2");


         int choice = sc.nextInt();

         switch (choice) {
            case 1:
               parkCar();
               break;
            case 2:
               knowNumberOfFreePlaces();
               break;
            case 3:
               viewListCarsAboutEntrance();
               break;
            case 4:
               viewListCarsAboutExit();
               break;
            case 5:
               viewListOfAttempts();
               break;
            case 6:
               toEnter1();
               break;
            case 7:
               toEnter2();
               break;
            case 8:
               toExit1();
               break;
            case 9:
               toExit2();
               break;
            default:
               System.out.println("Неправильный выбор. Попробуйте снова.");
         }
      }
   }
   /** Метод, с помощию которого можно припарковать машину. В зависимости от выбора въезда, счетчик в классе Entrance накапливает число, которое при выборе пункта 3 поможет нам выдать ответ
    *
    */
   public static void parkCar() {
      if (availablePlaces == 0) {
         System.out.println("Извините, но свободных мест.");
         return;
      } else {
         System.out.println("Места есть, ввведите номер машины и номер въезда: ");
         Scanner sc2 = new Scanner(System.in);
         Cars.licensePlate = sc2.nextInt();
         entrance = sc2.nextInt();
         if (entrance == 1) {
            Entrance.count1++;
         } else if (entrance==2) {
            Entrance.count2++;
         }
         availablePlaces--;
         System.out.println("Автомобиль успешно припаркован!");
      }
   }
   /** Метод, показывающий нам количество свободных местна парковке
    *
    */
   public static void knowNumberOfFreePlaces() {
      System.out.println("Мест осталось: " + availablePlaces);
   }
   /** Метод, показывающий список машин, проезжавших через определенные въезды
    *
    */
   private static void viewListCarsAboutEntrance() {
      Scanner sc2 = new Scanner(System.in);
      System.out.println("Выберите номер въезда: ");
      if (sc2.nextInt() == 1) {
         System.out.println(Entrance.count1);
         System.out.println(Cars.licensePlate);
      } else if (sc2.nextInt() == 2) {
         System.out.println(Entrance.count2);
      }

   }
   /** Метод, показывающий список машин, проезжавших через определенные выезды
    *
    */
   private static void viewListCarsAboutExit() {
      Scanner sc1 = new Scanner(System.in);
      System.out.println("Выберите номер выезда: ");
      if (sc1.nextInt() == 1) {
         System.out.println(Exit.count1);
   } else if (sc1.nextInt() == 2) {
         System.out.println(Exit.count2);
      }
   }
   /** Метод, показывающий кол-во попыток въезда на парковку (недоделала)
    *
    */
   private static void viewListOfAttempts() {
   }
   /** Метод, помогающий въехать на парковку через 1-ый въезд. Здесь требуется прописать номер машины, чтобы при выводе списка автомобилей, который проезжали через определенный въезд, нам выводился номер автомобиля
    *
    */
   private static void toEnter1() {
      if (availablePlaces > 0) {
         System.out.println("Места есть! Введите номер машины: ");
         Scanner sc3 = new Scanner(System.in);
         Cars.licensePlate = sc3.nextInt();
            Entrance.count1++;

         }
      }
   /** Метод, помогающий въехать на парковку через 2-ый въезд. Здесь требуется прописать номер машины, чтобы при выводе списка автомобилей, который проезжали через определенный въезд, нам выводился номер автомобиля
    *
    */
   private static void toEnter2() {
      if (availablePlaces > 0) {
         System.out.println("Места есть! Введите номер машины: ");
         Scanner sc3 = new Scanner(System.in);
         Cars.licensePlate = sc3.nextInt();
            Entrance.count2++;
} }
   /** Метод, помогающий выехать из парковку через 1-ый выезд. Здесь требуется прописать номер машины, чтобы при выводе списка автомобилей, который проезжали через определенный выезд, нам выводился номер автомобиля
    *
    */
   private static void toExit1() {
      System.out.println("Перед выездом введите номер машины: ");
      Scanner sc3 = new Scanner(System.in);
      Cars.licensePlate = sc3.nextInt();
         Exit.count1++;
   }
   /** Метод, помогающий выехать из парковку через 2-ый выезд. Здесь требуется прописать номер машины, чтобы при выводе списка автомобилей, который проезжали через определенный выезд, нам выводился номер автомобиля
    *
    */
   private static void toExit2() {
      System.out.println("Перед выездом введите номер машины: ");
      Scanner sc3 = new Scanner(System.in);
      Cars.licensePlate = sc3.nextInt();
      Exit.count2++;
   }
}

/** Класс, отвечающий за въезды (их 2)
 *
 */
class Entrance {
   static int[] entrances = new int[2];
   static int count1 = 0;
   static int count2 = 0;
}
/** Класс, отвечающий за выезды (их 2)
 *
 */

   class Exit {
      static int[] entrances = new int[2];
      static int count1 = 0;
      static int count2 = 0;
   }
/** Класс, отвечающий за машины
 *
 */
   class Cars {
      static int licensePlate;
   }