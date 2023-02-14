
import java.util.ArrayList;
import java.util.List;
public class RobotMap {
    private int m;
    private int n;
    private final List <Robot> robots;
    private int robot_Quantity;
    public static final int  ROBOT_QUANTITY = 5;

    public RobotMap(int n, int m, int robot_Quantity){
        //Добавить валидацию параметров при создании карты
        if (n < 0 || 0 > m ) {
        throw new IllegalStateException("Некорректное значние карты");
        }
        this.m = m;
        this.n = n;
        //Реализовать возможность задать ограничение по количеству создаваемых на карте роботов (в конструкторе карты).
        this.robot_Quantity = robot_Quantity;
        this.robots = new ArrayList<>();        
    }

    public RobotMap(int n, int m){
        if (n < 0 || 0 > m ) {
        throw new IllegalStateException("Некорректное значние карты");
        }
        this.m = m;
        this.n = n;
        //Реализовать возможность задать ограничение по количеству создаваемых на карте роботов (в конструкторе карты).
        this.robot_Quantity = ROBOT_QUANTITY;
        this.robots = new ArrayList<>();        
    }
    public Robot createRobot(Point point){
        validatePoint(point);
        // проверяем количество создаваемых на карте роботов
        int i = 0;
        for(var item:robots){
            i++;
        }
        if (robot_Quantity<=i) { throw new IllegalStateException("Некорректное значние количества роботов"); }
        Robot robot = new Robot(point);
        robots.add(robot);
        return robot;
        
    }
    public void validatePoint(Point point){
        validatePointIsCorrect(point);
        validatePointIsFree(point);
    }

    public void validatePointIsCorrect(Point point){
        if (point.x() < 0 || point.x() > n || point.y() < 0|| point.y() >m ){
            throw new IllegalStateException("Некорректное значние точки");
        }
    } 
    public void validatePointIsFree(Point point){
        for (Robot robot:robots){
            if (robot.point.equals(point)){
                throw new IllegalStateException("Точка "+point+" занята!");
            }
        }
    }
    public class Robot{

        public static final Direction DEFAULT_DIRECTION = Direction.TOP;
        private Direction direction;
        private Point point;

        public Robot(Point point){
            this.direction = DEFAULT_DIRECTION;
            this.point = point;
        }
        public void changeDirection(Direction direction){
            this.direction = direction;
        }
        //Реализовать возможность вызова метода move с параметром - количество шагов вперед. Подсказка: можно несколько раз 
        //вызвать метод #move
        public void move(int step){
            for (int i = 0; i < step; i++) {
                Point newPoint = switch (direction) {
                case TOP->new Point(point.x()-1, point.y());
                case RIGHT->new Point(point.x(), point.y()+1);
                case BOTTOM->new Point(point.x()+1, point.y());   
                case LEFT->new Point(point.x(), point.y()-1);  
            };
            validatePoint(newPoint);
            System.out.println("Робот переместился с "+point+" на "+newPoint);
            this.point = newPoint;
        }
        }

        @Override
        public String toString() {
            
            return point.toString()+ "[" + direction.name()+"]";
        }
    }
}
