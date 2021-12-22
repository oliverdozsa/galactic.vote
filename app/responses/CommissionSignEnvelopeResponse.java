package responses;

public class CommissionSignEnvelopeResponse {
    private String envelopeSignatureBase64;

    public String getEnvelopeSignatureBase64() {
        return envelopeSignatureBase64;
    }

    public void setEnvelopeSignatureBase64(String envelopeSignatureBase64) {
        this.envelopeSignatureBase64 = envelopeSignatureBase64;
    }

    @Override
    public String toString() {
        return "CommissionSignEnvelopeResponse{" +
                "envelopeSignatureBase64='" + envelopeSignatureBase64 + '\'' +
                '}';
    }
}
