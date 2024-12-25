package AA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BusStop {
    String name;
    double latitude;
    double longitude;

    BusStop(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

class ClassRoom {
    String name;
    double latitude;
    double longitude;

    ClassRoom(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

class ShortestPath {
    BusStop busStop;
    ClassRoom classRoom;
    double distance;

    ShortestPath(BusStop busStop, ClassRoom classRoom, double distance) {
        this.busStop = busStop;
        this.classRoom = classRoom;
        this.distance = distance;
    }
}

public class A1 {
   
    static List<ShortestPath> recommendations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        System.out.println("버스정류장 이름을 입력하세요:");
        String busStopName = scanner.nextLine();
        System.out.println("버스정류장의 위도:");
        double busStopLat = scanner.nextDouble();
        System.out.println("버스정류장의 경도:");
        double busStopLon = scanner.nextDouble();

        System.out.println("강의실 이름을 입력하세요:");
        scanner.nextLine(); 
        String classRoomName = scanner.nextLine();
        System.out.println("강의실의 위도:");
        double classRoomLat = scanner.nextDouble();
        System.out.println("강의실의 경도:");
        double classRoomLon = scanner.nextDouble();

       
        System.out.println("추천한 최단 거리 (km):");
        double recommendedDistance = scanner.nextDouble();

    
        BusStop busStop = new BusStop(busStopName, busStopLat, busStopLon);
        ClassRoom classRoom = new ClassRoom(classRoomName, classRoomLat, classRoomLon);

      
        ShortestPath shortestPath = new ShortestPath(busStop, classRoom, recommendedDistance);
        recommendations.add(shortestPath);

      
        recommendShortestPath();
    }

    public static void recommendShortestPath() {
        if (recommendations.isEmpty()) {
            System.out.println("추천된 최단 거리가 없습니다.");
            return;
        }

      
        ShortestPath bestPath = recommendations.get(0);
        for (ShortestPath path : recommendations) {
            if (path.distance < bestPath.distance) {
                bestPath = path;
            }
        }


        System.out.println("추천된 최단 거리:");
        System.out.println("버스정류장: " + bestPath.busStop.name);
        System.out.println("강의실: " + bestPath.classRoom.name);
        System.out.println("최단 거리: " + bestPath.distance + " km");
    }
}
