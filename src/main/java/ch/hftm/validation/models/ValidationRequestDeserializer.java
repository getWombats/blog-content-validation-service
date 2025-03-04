package ch.hftm.validation.models;

import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class ValidationRequestDeserializer extends JsonbDeserializer<ValidationRequest> {
    public ValidationRequestDeserializer() {
        super(ValidationRequest.class);
    }
}
