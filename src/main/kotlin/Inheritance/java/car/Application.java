package Inheritance.java.car;


public class Application {
    public static void main(String[] args){
        EngineController engineController = new EngineController();
        engineController.optimizeEnginePerformance();

        TelematicsController telematicsController = new TelematicsController();
        telematicsController.sendDiagnosticsData("Example diagonostics data");
        telematicsController.receiveUpdates();

        SafetyController safetyController = new SafetyController();
        safetyController.monitorAndAct();
    }
}
