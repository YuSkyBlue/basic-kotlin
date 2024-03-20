package Inheritance.java.car;


// 자동 비상 제동, 차선 유지 보조 등의 기능을 구현합니다.
public class SafetyController {
    private CollisionDetector collisionDetector;
    private LaneKeepingAssistant laneKeepingAssistant;

    public SafetyController() {
        this.collisionDetector = new CollisionDetector();
        this.laneKeepingAssistant = new LaneKeepingAssistant();
    }

    public void monitorAndAct() {
        if (collisionDetector.detectPotentialCollision()) {
            // Initiate emergency braking
        }
        if (!laneKeepingAssistant.isLaneKept()) {
            // Adjust steering to maintain lane
        }
    }
}
