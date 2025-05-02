// Common Interface for all old chargers
interface OldCharger {
    void oldCharge();
}

// Old Samsung Charger
class OldSamsungCharger implements OldCharger {
    public void oldCharge() {
        System.out.println("Charging using Old Samsung Charger");
    }
}

// Old Nokia Charger
class OldNokiaCharger implements OldCharger {
    public void oldCharge() {
        System.out.println("Charging using Old Nokia Charger");
    }
}

// Old Phone (Client)
class OldPhone {
    private OldCharger charger;

    public OldPhone(OldCharger charger) {
        this.charger = charger;
    }

    public void chargePhone() {
        System.out.println("Starting the charging process...");
        charger.oldCharge();  // using oldCharge method
        System.out.println("Charging completed.");
    }
}

// New Interface expected by Phone
interface NewCharger {
    void newCharge();
}

// New Phone (Client)
class NewPhone {
    private NewCharger charger;

    public NewPhone(NewCharger charger) {
        this.charger = charger;
    }

    public void chargePhone() {
        System.out.println("Starting the charging process...");
        charger.newCharge();  // using newCharge method
        System.out.println("Charging completed.");
    }
}

// Single Generic Adapter
class ChargerAdapter implements NewCharger {
    private OldCharger oldCharger;

    public ChargerAdapter(OldCharger oldCharger) {
        this.oldCharger = oldCharger;
    }

    public void newCharge() {
        oldCharger.oldCharge();
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        // Old Phone using Old Charger (Old Method)
        OldCharger samsungChargerOld = new OldSamsungCharger();
        OldPhone oldPhone = new OldPhone(samsungChargerOld);
        oldPhone.chargePhone();

        System.out.println("-----");

        // New Phone using Adapter to use Old Charger
        OldCharger samsungChargerNew = new OldSamsungCharger();
        NewCharger samsungAdapter = new ChargerAdapter(samsungChargerNew);
        NewPhone newPhone1 = new NewPhone(samsungAdapter);
        newPhone1.chargePhone();

        System.out.println("-----");

        // New Phone using Adapter for Nokia Charger
        OldCharger nokiaChargerNew = new OldNokiaCharger();
        NewCharger nokiaAdapter = new ChargerAdapter(nokiaChargerNew);
        NewPhone newPhone2 = new NewPhone(nokiaAdapter);
        newPhone2.chargePhone();
    }
}
