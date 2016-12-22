package profileData;

/**
 * Created by madja_000 on 22.11.2016.
 */
public class ProfileData {
    private String firstName;
    private String lastName;
    private String companyName;
    private String webSite;
    private String title;
    private String phone;
    private String timeZone;
    private int itemsPerPage;
    private int maximumFileAge;


    public ProfileData(String firstName, String lastName, String companyName, String webSite, String title, String phone, String timeZone, int itemsPerPage, int maximumFileAge) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.webSite = webSite;
        this.title = title;
        this.phone = phone;
        this.timeZone = timeZone;
        this.itemsPerPage = itemsPerPage;
        this.maximumFileAge = maximumFileAge;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getWebSite() {
        return webSite;
    }

    public String getTitle() {
        return title;
    }

    public String getPhone() {
        return phone;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public int getMaximumFileAge() {
        return maximumFileAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfileData that = (ProfileData) o;

        if (itemsPerPage != that.itemsPerPage) return false;
        if (maximumFileAge != that.maximumFileAge) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (webSite != null ? !webSite.equals(that.webSite) : that.webSite != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        return timeZone != null ? timeZone.equals(that.timeZone) : that.timeZone == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (webSite != null ? webSite.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (timeZone != null ? timeZone.hashCode() : 0);
        result = 31 * result + itemsPerPage;
        result = 31 * result + maximumFileAge;
        return result;
    }
}
