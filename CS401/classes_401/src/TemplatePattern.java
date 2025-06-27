public class TemplatePattern {
}


abstract class BeverageMaker {
    public final void makeBeverage() {
        this.brew();
        this.addCondiments();
        this.boilWater();
        this.pourInCup();
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("boiling water");
    }

    void pourInCup() {
        System.out.println("pour in the cup");
    }
}

class Beer extends BeverageMaker {
    @Override
    void brew() {
        System.out.println("brewed the coffee ...");
    }

    @Override
    void addCondiments() {
        System.out.println("condiments are added in beer");
    }
}