package Inheritance.java.car;

// 연료 분사, 점화 시기 등 자동차 엔진의 다양한 측면을 모니터링하고 제어하는 일을 담당합니다.
public class EngineController {
    private FuelInjector fuelInjector;
    private IgnitionController ignitionController;

    public EngineController() {
        this.fuelInjector = new FuelInjector();
        this.ignitionController = new IgnitionController();
    }

    public void optimizeEnginePerformance() {
        // Example method to optimize engine performance
        fuelInjector.adjustFuelAmount();
        ignitionController.adjustTiming();
    }
}
