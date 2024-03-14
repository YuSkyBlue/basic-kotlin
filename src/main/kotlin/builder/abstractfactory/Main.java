package builder.abstractfactory;

interface Plant {
}

class OrangePlant implements Plant {
    OrangePlant() {
        System.out.println("OrangePlant MAKE");
    }
}

class ApplePlant implements Plant {
  ApplePlant(){
      System.out.println("ApplePlant MAKE");

  }
}

abstract class PlantFactory {
    abstract Plant makePlan();

    static PlantFactory createFactory(Class<? extends Plant> clazz) {
        if (clazz.equals(OrangePlant.class)) {
            return new OrangeFactory();
        } else if (clazz.equals(ApplePlant.class)) {
            return new AppleFactory();
        } else {
            throw new IllegalArgumentException();
        }
    }
}

class AppleFactory extends PlantFactory {
    @Override
    Plant makePlan() {
        return new ApplePlant();
    }
}

class OrangeFactory extends PlantFactory {
    @Override
    Plant makePlan() {
        return new OrangePlant();
    }
}

class AbstractFactory
{
    public static void main(String[] args) {
        PlantFactory plantFactory1 = PlantFactory.createFactory(OrangePlant.class);
        System.out.println("Create Plant " + plantFactory1.makePlan());

        PlantFactory plantFactory2 = PlantFactory.createFactory(ApplePlant.class);
        System.out.println("Create Plant " + plantFactory2.makePlan());

    }
}
