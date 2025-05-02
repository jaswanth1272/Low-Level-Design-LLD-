// State interface
interface VendingMachineState {
    void insertMoney();
    void pressButton();
    void dispense();
}

// Concrete State 1: NoMoneyState
class NoMoneyState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public NoMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void insertMoney() {
        System.out.println("Money inserted.");
        vendingMachine.setState(vendingMachine.getHasMoneyState());
    }

    public void pressButton() {
        System.out.println("Please insert money first.");
    }

    public void dispense() {
        System.out.println("Can't dispense, insert money first.");
    }
}

// Concrete State 2: HasMoneyState
class HasMoneyState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public HasMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void insertMoney() {
        System.out.println("Money already inserted.");
    }

    public void pressButton() {
        System.out.println("Button pressed. Dispensing item...");
        vendingMachine.setState(vendingMachine.getDispensingState());
    }

    public void dispense() {
        System.out.println("Please press the button to dispense.");
    }
}

// Concrete State 3: DispensingState
class DispensingState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public DispensingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void insertMoney() {
        System.out.println("Please wait, dispensing item...");
    }

    public void pressButton() {
        System.out.println("Dispensing in progress...");
    }

    public void dispense() {
        System.out.println("Item dispensed.");
        vendingMachine.setState(vendingMachine.getNoMoneyState());
    }
}

// Context: VendingMachine
class VendingMachine {
    private VendingMachineState noMoneyState;
    private VendingMachineState hasMoneyState;
    private VendingMachineState dispensingState;
    
    private VendingMachineState currentState;

    public VendingMachine() {
        noMoneyState = new NoMoneyState(this);
        hasMoneyState = new HasMoneyState(this);
        dispensingState = new DispensingState(this);
        
        currentState = noMoneyState;
    }

    public void insertMoney() {
        currentState.insertMoney();
    }

    public void pressButton() {
        currentState.pressButton();
    }

    public void dispense() {
        currentState.dispense();
    }

    public void setState(VendingMachineState state) {
        this.currentState = state;
    }

    public VendingMachineState getNoMoneyState() {
        return noMoneyState;
    }

    public VendingMachineState getHasMoneyState() {
        return hasMoneyState;
    }

    public VendingMachineState getDispensingState() {
        return dispensingState;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        
        vendingMachine.insertMoney();
        vendingMachine.pressButton();
        vendingMachine.dispense();
        
        vendingMachine.insertMoney();
        vendingMachine.pressButton();
        vendingMachine.dispense();
    }
}
