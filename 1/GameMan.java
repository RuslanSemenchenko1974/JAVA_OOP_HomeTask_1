/**
 
Разобраться с проектом. Подготовить вопросы к следующему семинару, если возникнут.
Добавить валидацию параметров при создании карты
Реализовать возможность задать ограничение по количеству создаваемых на карте роботов (в конструкторе карты). 
При этом если параметр не указан, то используем значение по-умолчанию: 5
Реализовать возможность вызова метода move с параметром - количество шагов вперед. Подсказка: можно несколько раз 
вызвать метод #move


 */
public class GameMan {

    public static void main(String[] args) {
        System.out.print("\033\143");
        
        RobotMap map = new RobotMap(10, 10);
        RobotMap.Robot robot = map.createRobot(new Point(5, 5));
        RobotMap.Robot robot1 = map.createRobot(new Point(5, 7));
        RobotMap.Robot robot2 = map.createRobot(new Point(1, 1));
        RobotMap.Robot robot3 = map.createRobot(new Point(2, 1));
        RobotMap.Robot robot4 = map.createRobot(new Point(9, 8));
       // RobotMap.Robot robot5 = map.createRobot(new Point(4, 1));
        System.out.println(robot);
        robot.move(1);        
        robot.changeDirection(Direction.BOTTOM);
        robot.move(2);
        robot.move(3);
        robot.changeDirection(Direction.LEFT);
        robot.move(1);
        
    }
}