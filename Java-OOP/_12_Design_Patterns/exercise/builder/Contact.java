package builder;

public class Contact {

    private String name;
    private String number;
    private String company;
    private String title;
    private String email;
    private String website;
    private String birthday;

    public Contact(Builder builder) {
        this.name = builder.name;
        this.number = builder.number;
        this.company = builder.company;
        this.title = builder.title;
        this.email = builder.email;
        this.website = builder.website;
        this.birthday = builder.birthday;
    }

    public String getName() {
        return name;
    }


    public String getNumber() {
        return number;
    }


    public String getCompany() {
        return company;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }

    public String getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Contact{" +
               "name='" + name + '\'' +
               ", number='" + number + '\'' +
               ", company='" + company + '\'' +
               ", title='" + title + '\'' +
               ", email='" + email + '\'' +
               ", website='" + website + '\'' +
               ", birthday=" + birthday +
               '}';
    }

    public static class Builder {

        private String name;
        private String number;
        private String company;
        private String title;
        private String email;
        private String website;
        private String birthday;

        // Required fields
        public Builder(String name, String number) {
            this.name = name;
            this.number = number;
        }

        // Optional fields
        public Builder withCompany(String company) {
            this.company = company;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withWebsite(String website) {
            this.website = website;
            return this;
        }

        public Builder withBirthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        public Contact build() {
            validateFields();
            return new Contact(this);
        }

        private void validateFields() {
            StringBuilder errorMessages = new StringBuilder();

            if (name == null || name.trim().equals("") || name.length() < 2) {
                errorMessages.append("The name must contain at least 2 characters!")
                             .append(System.lineSeparator());
            }

            if (number == null || number.trim().equals("") || number.length() < 5) {
                errorMessages.append("The number must contain at least 5 characters!")
                             .append(System.lineSeparator());
            }

            if (errorMessages.length() > 0) {
                throw new IllegalArgumentException(errorMessages.toString());
            }

        }
    }
}
