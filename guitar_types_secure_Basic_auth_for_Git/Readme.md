# Actuator
Call
http://localhost:8080/actuator

# TestUser
http://localhost:8080/guitar-types
user
pw

 # React project is under:
/home/tkalman/tiborreact/guitar_types_react_frontend/

Maven muss erst rechts in Navigation aktiviert werden.



MySQL on Linux:
https://www.computerweekly.com/de/ratgeber/Wie-man-eine-MySQL-Datenbank-unter-Linux-einrichtet

sudo apt-get install mysql-server -y

->mysqld is running as pid 8044

sudo systemctl enable --now mysql


sudo mysql_secure_installation


Starten:
sudo mysql -u root -p

pw: rootpw1234___


CREATE DATABASE guitar_types2;

CREATE USER 'guitaruser'@'localhost' IDENTIFIED with mysql_native_password BY 'guitarPW1234§$%';
GRANT ALL ON guitaruser.* To 'guitaruser'@'localhost' WITH GRANT OPTION;
GRANT ALL ON guitar_types2.* To 'guitaruser'@'localhost' WITH GRANT OPTION;

CREATE USER 'guitaruser2'@'localhost' IDENTIFIED with mysql_native_password BY 'guitarPW1234§$%';
GRANT ALL ON guitar_types2.* To 'guitaruser2'@'localhost' WITH GRANT OPTION;

GRANT ALL ON guitar_types2.* To 'root'@'localhost' WITH GRANT OPTION;

mysql> show databases;


mysql> SHOW GLOBAL VARIABLES LIKE 'PORT';
+---------------+-------+
| Variable_name | Value |
+---------------+-------+
| port          | 3306  |
+---------------+-------+
1 row in set (0,00 sec)



mysql> SELECT * from mysql.user;


mysql>exit;


sudo mysqld_safe --skip-grant-tables


ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'rootpw1234§$%';
ALTER USER 'guitaruser2'@'localhost' IDENTIFIED WITH mysql_native_password BY 'guitarPW1234§$%';
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'rootPW1234§$!';

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'rootPW1234___';

# Password Encoder

package website.kalman.guitar_types.utils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
public class PasswordEncoderNew {
    public static void main(String[] args) {
       // PasswordEncoder pe = new BCryptPasswordEncoder();
       // System.out.println(pe.encode("pw"));
    }
}