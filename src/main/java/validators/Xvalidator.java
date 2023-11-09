package validators;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;


@FacesValidator("xValidator")
public class Xvalidator implements Validator<Double> {

    private static final double X_MAX = 2.0;
    private static final double X_MIN = -2.0;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Double object) throws ValidatorException {
        if (object == null) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, null,
                            "Введите значение координаты X"));
        }

        if (object > X_MAX || object < X_MIN) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, null,
                            "Значение X выходит за пределы [-2;2]"));
        }

    }
}