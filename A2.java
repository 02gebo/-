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
    String imagePath; 

    ClassRoom(String name, double latitude, double longitude, String imagePath) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imagePath = imagePath; 
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

public class A2 {

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
        scanner.nextLine(); 
        System.out.println("강의실의 사진 경로를 입력하세요 (예: C:/images/classroom.jpg):");
        String classRoomImagePath = scanner.nextLine();

        
        System.out.println("추천한 최단 거리 (km):");
        double recommendedDistance = scanner.nextDouble();

      
        BusStop busStop = new BusStop(busStopName, busStopLat, busStopLon);
        ClassRoom classRoom = new ClassRoom(classRoomName, classRoomLat, classRoomLon, classRoomImagePath);

        
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
        System.out.println("강의실 사진 경로: " + bestPath.classRoom.imagePath);
    }

    
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int EARTH_RADIUS = 6371; 

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c; 
    }
}
