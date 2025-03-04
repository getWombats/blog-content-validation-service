package ch.hftm.validation.control;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import ch.hftm.validation.models.ValidationRequest;
import ch.hftm.validation.models.ValidationResponse;
import io.quarkus.logging.Log;
import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ValidationService {
    @Incoming("validation-request")
    @Outgoing("validation-response")
    public Multi<ValidationResponse> validateTextMessages(Multi<ValidationRequest> requests) {
        return requests
                .onItem().transform(request -> {
                    boolean valid = !request.text().contains("simeon mag angular");
                    Log.debug("Text-Validation: " + request.text() + " -> " + valid);
                    return new ValidationResponse(request.id(), valid);
                });
    }
}
