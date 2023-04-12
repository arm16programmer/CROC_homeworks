package lesson_5.taskSystem;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


    public class taskSystem {
        private static final String TASK_FILE_NAME = "tasks.dat"; // константа, хранящая в себе название файла

        /**
         * метод, воспроизводящий работу кода
         */
        public static void main(String[] args) {
            // подгружаем задачи из файла
            Task[] tasks = loadTasks(); // массив, в котором хранятся подгружаемые из метода loadTasks файлы

            // показываем главное меню задач
            showMainMenu(tasks); // вызов метода, показывающего меню задач
        }

        /**
         * подгружаем задачи из файла
         */
        private static Task[] loadTasks() {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(TASK_FILE_NAME))) {
                return (Task[]) input.readObject();
            } catch (Exception e) {
                // обработка ошибки
                System.err.println("Появилась ошибка при загрузке файла: " + e.getMessage());
                return new Task[0];
            }
        }

        /**
         * сохраняем задачи в файловой системе
         */
        private static void saveTasks(Task[] tasks) {
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(TASK_FILE_NAME))) {
                output.writeObject(tasks);
            } catch (Exception e) {
                // выдается ошибка
                System.err.println("Появилась ошибка при сохранении файла: " + e.getMessage());
            }
        }

        /**
         * метод, показывающий меню
         */
        private static void showMainMenu(Task[] tasks) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Система ведения задач");
                System.out.println("1. Создать задачу");
                System.out.println("2. Редактировать задачу");
                System.out.println("3. Удалить задачу");
                System.out.println("4. Выйти");
                System.out.print("Ваш выбор: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        createTask(tasks);
                        break;
                    case 2:
                        editTask(tasks);
                        break;
                    case 3:
                        deleteTask(tasks);
                        break;
                    case 4:
                        saveTasks(tasks);
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Неправильный выбор!");
                }
            }
        }

        /**
         * метод, создающий задачи
         */
        private static void createTask(Task[] tasks) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Код задачи: ");
            String code = scanner.nextLine();

            System.out.print("Наименование задачи: ");
            String name = scanner.nextLine();

            System.out.print("Исполнитель задачи: ");
            String executor = scanner.nextLine();

            System.out.print("Статус задачи: ");
            String status = scanner.nextLine();

            // Конструктор новой задачи
            Task task = new Task(code, name, executor, status);

            // добавляем новую задачу в массив
            Task[] newTasks = new Task[tasks.length + 1];
            System.arraycopy(tasks, 0, newTasks, 0, tasks.length); // копирование одного массива в другой
                                                                                // [копируемый массив, с какого элемента копировать,
                                                                                // целевой массив, начальный элемент в целевом массиве,
                                                                                // кол-во копиуремых элементов]
            newTasks[tasks.length] = task;
            tasks = newTasks;

            System.out.println("Задача успешно добавлена!");
        }

        /**
         * редактирование существующих задач
         */
        private static void editTask(Task[] tasks) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите код задачи: ");
            String code = scanner.nextLine();

            // поиск задачи
            Task task = null;
            for (Task t : tasks) {
                if (t.getCode().equals(code)) {
                    task = t;
                    break;
                }
            }

            if (task == null) {
                System.out.println("Такой задачи не существует.");
                return;
            }

            System.out.print("Введите наименование задачи: ");
            String name = scanner.nextLine();

            System.out.print("Введите исполнителя задачи: ");
            String executor = scanner.nextLine();

            System.out.print("Введите статус задачи: ");
            String status = scanner.nextLine();

            // обновляем задачу
            task.setName(name);
            task.setExecutor(executor);
            task.setStatus(status);

            System.out.println("Задача успешно отредактирована.");
        }

        /**
         * метод, удаляющий задачу
         */
        private static void deleteTask(Task[] tasks) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Код задачи: ");
            String code = scanner.nextLine();

            // поиск задачи
            Task task = null;
            int taskIndex = -1;
            for (int i = 0; i < tasks.length; i++) {
                if (tasks[i].getCode().equals(code)) {
                    task = tasks[i];
                    taskIndex = i;
                    break;
                }
            }

            if (task == null) {
                System.out.println("Такой задачи нет");
                return;
            }

            // Remove task from array
            Task[] newTasks = new Task[tasks.length - 1];
            System.arraycopy(tasks, 0, newTasks, 0, taskIndex);
            System.arraycopy(tasks, taskIndex + 1, newTasks, taskIndex, tasks.length - taskIndex - 1);
            tasks = newTasks;

            System.out.println("Задача удалена успешно.");
        }



    }

