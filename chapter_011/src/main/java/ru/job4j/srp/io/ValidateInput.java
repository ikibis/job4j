package ru.job4j.srp.io;

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
            case "FirstNumber":
                if (this.isNumberChecker(input)) {
                    response = new Output(Double.valueOf(input.getInput()), "ok");
                } else if (input.getInput().toUpperCase().equals("MR")) {
                    response = new Output("MR", "ok");
                }
                break;
            case "SecondNumber":
                if (this.isNumberChecker(input)) {
                    response = new Output(Double.valueOf(input.getInput()), "ok");
                } else if (input.getInput().toUpperCase().equals("MR")) {
                    response = new Output("MR", "ok");
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
}
