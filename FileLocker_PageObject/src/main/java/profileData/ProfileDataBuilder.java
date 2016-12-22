package profileData;

/**
 * Created by madja_000 on 22.11.2016.
 */
public class ProfileDataBuilder {
    private String firstName ="";
    private String lastName="";
    private String companyName="";
    private String webSite="";
    private String title="";
    private String phone ="";
    private String timeZone="";
    private int itemsPerPage;
    private int maximumFileAge;

    public ProfileDataBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ProfileDataBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ProfileDataBuilder setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public ProfileDataBuilder setWebSite(String webSite) {
        this.webSite = webSite;
        return this;
    }

    public ProfileDataBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public ProfileDataBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public ProfileDataBuilder setTimeZone(String timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    public ProfileDataBuilder setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
        return this;
    }

    public ProfileDataBuilder setMaximumFileAge(int maximumFileAge) {
        this.maximumFileAge = maximumFileAge;
        return this;
    }

    public ProfileData build(){
        return new ProfileData(firstName,lastName,companyName,webSite, title,  phone,timeZone,itemsPerPage, maximumFileAge);
    }
}
