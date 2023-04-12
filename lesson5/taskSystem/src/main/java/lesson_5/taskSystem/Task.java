package lesson_5.taskSystem;

/**
 * класс самой задачи
 */

public class Task implements java.io.Serializable{
        private String code;
        private String name;
        private String executor;
        private String status;

        /**
         * конструктор новой задачи
         */
        public Task(String code, String name, String executor, String status) {
            this.code = code;
            this.name = name;
            this.executor = executor;
            this.status = status;
        }
        public String getCode() {
            return code;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setExecutor(String executor) {
            this.executor = executor;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
