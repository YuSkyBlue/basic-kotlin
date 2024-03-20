package Inheritance.java.car;

// 진단, 소프트웨어 업데이트 등을 위해 외부 시스템과의 통신을 처리합니다.
public class TelematicsController {
    public void sendDiagnosticsData(String data) {
        // Send diagnostics data to a remote server
        System.out.println("sendDiagnosticsData " + data);

    }

    public void receiveUpdates() {
        // Receive software updates or commands from a remote server
        System.out.println("receiveUpdates");

    }
}