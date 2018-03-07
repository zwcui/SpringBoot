package mobi.zhanglv.model;

import java.io.Serializable;

public class User {

    public User(){}

    private Long uId;

    private String phoneNumber;

    private String password;

    private String salt;

    private String nickName;

    private String avatar;

    private Integer gender;

    private Integer age;

    private Integer type;

    private Long created;

    private Long updated;

    private Integer thirdAuthType;

    private String thirdAuthId;

    private String thirdAuthToken;

    private Integer fansNum;

    private Integer guestsNum;

    private Integer verifiedStatus;

    private Integer followingNum;

    private Integer avNum;

    private String tags;

    private String tagIds;

    private Long deletedAt;

    private String videoUId;

    private Integer liveNum;

    private Integer zombie;

    private Integer signUpSysterm;

    private String signature;

    private String wechatUnionId;

    private String thirdBindPhoneNum;

    private String location;

    private Double star;

    private Integer onlineState;

    private Integer charge;

    private Long consultDuration;

    private Long sigExpireTime;

    private String sigName;

    private String tencentYunSig;

    private String realName;

    private String company;

    private Integer interactionNum;

    private String lawTags;

    private String lawTagIds;

    private Integer seniority;

    private Long seniorityDate;

    private Integer onlineSetState;

    private Integer lastOnlineSetState;

    private String channel;

    private Long billStartTime;

    private Integer compositeScore;

    private String locationCode;

    private Integer authScore;

    private Integer onlineScore;

    private Integer starScore;

    private Integer liveScore;

    private Integer officialIssueScore;

    private Integer billTimeScore;

    private Integer billCountScore;

    private Integer recommendListScore;

    private Integer recommendIssueScore;

    private Integer interactiveLive;

    private String registVersion;

    private Integer freeBillDuration;

    private Integer isFristLoginType;

    public User(Long uId, String phoneNumber, String password, String salt, String nickName, String avatar, Integer gender, Integer age, Integer type, Long created, Long updated, Integer thirdAuthType, String thirdAuthId, String thirdAuthToken, Integer fansNum, Integer guestsNum, Integer verifiedStatus, Integer followingNum, Integer avNum, String tags, String tagIds, Long deletedAt, String videoUId, Integer liveNum, Integer zombie, Integer signUpSysterm, String signature, String wechatUnionId, String thirdBindPhoneNum, String location, Double star, Integer onlineState, Integer charge, Long consultDuration, Long sigExpireTime, String sigName, String tencentYunSig, String realName, String company, Integer interactionNum, String lawTags, String lawTagIds, Integer seniority, Long seniorityDate, Integer onlineSetState, Integer lastOnlineSetState, String channel, Long billStartTime, Integer compositeScore, String locationCode, Integer authScore, Integer onlineScore, Integer starScore, Integer liveScore, Integer officialIssueScore, Integer billTimeScore, Integer billCountScore, Integer recommendListScore, Integer recommendIssueScore, Integer interactiveLive, String registVersion, Integer freeBillDuration, Integer isFristLoginType) {
        this.uId = uId;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.salt = salt;
        this.nickName = nickName;
        this.avatar = avatar;
        this.gender = gender;
        this.age = age;
        this.type = type;
        this.created = created;
        this.updated = updated;
        this.thirdAuthType = thirdAuthType;
        this.thirdAuthId = thirdAuthId;
        this.thirdAuthToken = thirdAuthToken;
        this.fansNum = fansNum;
        this.guestsNum = guestsNum;
        this.verifiedStatus = verifiedStatus;
        this.followingNum = followingNum;
        this.avNum = avNum;
        this.tags = tags;
        this.tagIds = tagIds;
        this.deletedAt = deletedAt;
        this.videoUId = videoUId;
        this.liveNum = liveNum;
        this.zombie = zombie;
        this.signUpSysterm = signUpSysterm;
        this.signature = signature;
        this.wechatUnionId = wechatUnionId;
        this.thirdBindPhoneNum = thirdBindPhoneNum;
        this.location = location;
        this.star = star;
        this.onlineState = onlineState;
        this.charge = charge;
        this.consultDuration = consultDuration;
        this.sigExpireTime = sigExpireTime;
        this.sigName = sigName;
        this.tencentYunSig = tencentYunSig;
        this.realName = realName;
        this.company = company;
        this.interactionNum = interactionNum;
        this.lawTags = lawTags;
        this.lawTagIds = lawTagIds;
        this.seniority = seniority;
        this.seniorityDate = seniorityDate;
        this.onlineSetState = onlineSetState;
        this.lastOnlineSetState = lastOnlineSetState;
        this.channel = channel;
        this.billStartTime = billStartTime;
        this.compositeScore = compositeScore;
        this.locationCode = locationCode;
        this.authScore = authScore;
        this.onlineScore = onlineScore;
        this.starScore = starScore;
        this.liveScore = liveScore;
        this.officialIssueScore = officialIssueScore;
        this.billTimeScore = billTimeScore;
        this.billCountScore = billCountScore;
        this.recommendListScore = recommendListScore;
        this.recommendIssueScore = recommendIssueScore;
        this.interactiveLive = interactiveLive;
        this.registVersion = registVersion;
        this.freeBillDuration = freeBillDuration;
        this.isFristLoginType = isFristLoginType;
    }

    public Long getuId() {
        return uId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public String getNickName() {
        return nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public Integer getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getType() {
        return type;
    }

    public Long getCreated() {
        return created;
    }

    public Long getUpdated() {
        return updated;
    }

    public Integer getThirdAuthType() {
        return thirdAuthType;
    }

    public String getThirdAuthId() {
        return thirdAuthId;
    }

    public String getThirdAuthToken() {
        return thirdAuthToken;
    }

    public Integer getFansNum() {
        return fansNum;
    }

    public Integer getGuestsNum() {
        return guestsNum;
    }

    public Integer getVerifiedStatus() {
        return verifiedStatus;
    }

    public Integer getFollowingNum() {
        return followingNum;
    }

    public Integer getAvNum() {
        return avNum;
    }

    public String getTags() {
        return tags;
    }

    public String getTagIds() {
        return tagIds;
    }

    public Long getDeletedAt() {
        return deletedAt;
    }

    public String getVideoUId() {
        return videoUId;
    }

    public Integer getLiveNum() {
        return liveNum;
    }

    public Integer getZombie() {
        return zombie;
    }

    public Integer getSignUpSysterm() {
        return signUpSysterm;
    }

    public String getSignature() {
        return signature;
    }

    public String getWechatUnionId() {
        return wechatUnionId;
    }

    public String getThirdBindPhoneNum() {
        return thirdBindPhoneNum;
    }

    public String getLocation() {
        return location;
    }

    public Double getStar() {
        return star;
    }

    public Integer getOnlineState() {
        return onlineState;
    }

    public Integer getCharge() {
        return charge;
    }

    public Long getConsultDuration() {
        return consultDuration;
    }

    public Long getSigExpireTime() {
        return sigExpireTime;
    }

    public String getSigName() {
        return sigName;
    }

    public String getTencentYunSig() {
        return tencentYunSig;
    }

    public String getRealName() {
        return realName;
    }

    public String getCompany() {
        return company;
    }

    public Integer getInteractionNum() {
        return interactionNum;
    }

    public String getLawTags() {
        return lawTags;
    }

    public String getLawTagIds() {
        return lawTagIds;
    }

    public Integer getSeniority() {
        return seniority;
    }

    public Long getSeniorityDate() {
        return seniorityDate;
    }

    public Integer getOnlineSetState() {
        return onlineSetState;
    }

    public Integer getLastOnlineSetState() {
        return lastOnlineSetState;
    }

    public String getChannel() {
        return channel;
    }

    public Long getBillStartTime() {
        return billStartTime;
    }

    public Integer getCompositeScore() {
        return compositeScore;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public Integer getAuthScore() {
        return authScore;
    }

    public Integer getOnlineScore() {
        return onlineScore;
    }

    public Integer getStarScore() {
        return starScore;
    }

    public Integer getLiveScore() {
        return liveScore;
    }

    public Integer getOfficialIssueScore() {
        return officialIssueScore;
    }

    public Integer getBillTimeScore() {
        return billTimeScore;
    }

    public Integer getBillCountScore() {
        return billCountScore;
    }

    public Integer getRecommendListScore() {
        return recommendListScore;
    }

    public Integer getRecommendIssueScore() {
        return recommendIssueScore;
    }

    public Integer getInteractiveLive() {
        return interactiveLive;
    }

    public String getRegistVersion() {
        return registVersion;
    }

    public Integer getFreeBillDuration() {
        return freeBillDuration;
    }

    public Integer getIsFristLoginType() {
        return isFristLoginType;
    }
}