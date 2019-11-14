package com.mock.ws.rest.pg.builder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.mock.ws.rest.bso.model.PGPartialPayment;
import com.mock.ws.rest.pg.dto.response.PGErrorDTO;
import com.mock.ws.rest.pg.dto.response.PGPartialPaymentDTO;
import com.mock.ws.rest.pg.dto.response.PGResponse;
import com.mock.ws.rest.pg.dto.response.PGStatusDTO;
import com.mock.ws.rest.utils.DateUtils;

public class PGResponseBuilder {

    public static final class Builder {

        private boolean result;
        private PGErrorDTO error;
        private String payID;
        private String amount;
        private String partSum;
        private PGPartialPaymentDTO[] partialPayments;
        private PGStatusDTO status;
        
        public Builder withResult(boolean result) {
            this.result = result;
            return this;
        }

        public Builder withError(String value, int code) {
            PGErrorDTO error = new PGErrorDTO();
            error.setCode(code);
            error.setValue(value);
            this.error = error;
            return this;
        }

        public Builder withPayID(String payID) {
            this.payID = payID;
            return this;
        }

        public Builder withAmount(BigDecimal amount) {
            this.amount = amount.setScale(2).toString();
            return this;
        }

        public Builder withPartSum(BigDecimal partSum) {
            this.partSum = partSum.setScale(2).toString();
            return this;
        }

        public Builder withPart(List<PGPartialPayment> payments) {
            List<PGPartialPaymentDTO> partialPayments = new ArrayList<>();

            if(payments != null && !payments.isEmpty()) {
                payments.forEach(payment -> {
                    PGPartialPaymentDTO partialPayment = new PGPartialPaymentDTO();
                    partialPayment.setAmount(payment.getAmount().setScale(2).toString());
                    partialPayment.setPaidDate(DateUtils.formatLong(payment.getPaidDateTime()));
                    partialPayment.setRrn(payment.getRrn());
                    partialPayment.setSessionId(payment.getSessionID());
                    partialPayment.setState(payment.getState());
                    partialPayment.setStateDescription(payment.getStateDescription());

                    partialPayments.add(partialPayment);
                });
            }
            this.partialPayments = partialPayments.stream().toArray(PGPartialPaymentDTO[]::new);

            return this;
        }

        public Builder withStatus() {
            PGStatusDTO status = new PGStatusDTO();
            status.setEmail(true);
            status.setPhone(true);
            this.status = status;
            return this;
        }

        public PGResponse buildResponse() {
            PGResponse response = new PGResponse();

            response.setResult(this.result);
            response.setPgError(this.error);
            response.setPayID(this.payID);
            response.setAmount(this.amount);
            response.setPartSum(this.partSum);
            response.setPartialPayments(this.partialPayments);
            response.setStatus(this.status);            
            return response;
        }
    }

    public static Builder build() {
        return new Builder();
    }
}
