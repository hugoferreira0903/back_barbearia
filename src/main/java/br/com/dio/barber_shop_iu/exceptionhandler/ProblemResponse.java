package br.com.dio.barber_shop_iu.exceptionhandler;

import java.time.OffsetDateTime;

public class ProblemResponse {
    private int status;
    private OffsetDateTime timestamp;
    private String message;


    private ProblemResponse(Builder builder) {
        this.status = builder.status;
        this.timestamp = builder.timestamp;
        this.message = builder.message;
    }

    public int getStatus() {
        return status;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }


    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {
        private int status;
        private OffsetDateTime timestamp;
        private String message;

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder timestamp(OffsetDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public ProblemResponse build() {
            return new ProblemResponse(this);
        }
    }
}
