package sql.demo.model;

import sql.demo.repository.TableOperations;

import java.sql.SQLException;

public class Trolleybus extends BaseModel implements TableOperations{
        private int number;
        private long latitude;
        private long longtude;
        public Trolleybus() {
        }
        public Trolleybus(long id, int number, long latitude, long longtude) {
                super(id);
                this.number = number;
                this.latitude = latitude;
                this.longtude = longtude;
        }

        public int getNumber() {
                return number;
        }

        public void setNumber(int number) {
                this.number = number;
        }

        public long getLatitude() {
                return latitude;
        }

        public void setLatitude(long latitude) {
                this.latitude = latitude;
        }

        public long getLongtude() {
                return longtude;
        }

        public void setLongtude(long longtude) {
                this.longtude = longtude;
        }

        @Override
        public void createTable() throws SQLException {

        }

        @Override
        public void createForeignKeys() throws SQLException {

        }
}


