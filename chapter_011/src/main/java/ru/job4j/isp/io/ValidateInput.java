package ru.job4j.isp.io;

public class ValidateInput {

    private static final ValidateInput VALIDATE_INPUT = new ValidateInput();

    public static ValidateInput getInstance() {
        return VALIDATE_INPUT;
    }

    public Output check(Input input) {
        Output response = new Output(null, "error");
        switch (input.getContext()) {
            case "PointOfMenu":
                if (this.isNumberChecker(input)) {
                    response = new Output(Integer.valueOf(input.getInput()), "ok");
                }
                break;
            case "ItemNumber":
                if (this.isItemNumberChecker(input)) {
                    response = new Output(input.getInput(), "ok");
                }
                break;
            default:
                break;
        }
        return response;
    }

    public boolean isNumberChecker(Input input) {
        boolean result = true;
        try {
            Integer.valueOf(input.getInput());
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    public boolean isItemNumberChecker(Input input) {
        boolean result = false;
        try {
            String inputToCheck = input.getInput();
            for (int i = 0; i < inputToCheck.length(); i++) {
                char c = inputToCheck.charAt(i);
                if ((c >= '0' && c <= '9') || (c == '.')) {
                    result = true;
                }
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
}
