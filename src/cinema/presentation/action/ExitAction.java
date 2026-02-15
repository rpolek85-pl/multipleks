package cinema.presentation.action;

public class ExitAction implements MenuAction {
    private final Runnable exitHandler;
    public ExitAction(Runnable exitHandler) {
        this.exitHandler = exitHandler;
    }

    @Override
    public String getName() {
        return "Zakończ";
    }

    @Override
    public void execute() {
        System.out.println("Zamykanie programu");
        exitHandler.run();
    }
}
