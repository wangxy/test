package prototype;

/**
 * Created by xwang on 5/23/16.
 */
public class PrototypeB implements Prototype {
    private String campaignId;
    private String tacticId;
    private int rank;
    private double modelScore;

    PrototypeB(String campaignId, String tacticId, int rank, double modelScore) {
        this.campaignId = campaignId;
        this.tacticId = tacticId;
        this.rank = rank;
        this.modelScore = modelScore;
    }

    public Prototype clone() {
        try {
            return (PrototypeB) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "PrototypeB{" +
                "campaignId='" + campaignId + '\'' +
                ", tacticId='" + tacticId + '\'' +
                ", rank=" + rank +
                ", modelScore=" + modelScore +
                '}';
    }
}
