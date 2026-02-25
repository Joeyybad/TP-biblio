package banque;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("OPE")
public class OperationStandard extends Operation {
    public OperationStandard() {
        super();
    }
}