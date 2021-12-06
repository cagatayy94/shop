package com.spring.shop.api.controller;

import com.github.javafaker.Faker;
import com.spring.shop.bussiness.abstracts.*;
import com.spring.shop.core.entities.Profile;
import com.spring.shop.entities.dtos.DatabaseSeederDto;
import com.spring.shop.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/v1/db/seeder/")
public class DbSeederController {
    private final PlatformUserService platformUserService;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final ProductPhotoService productPhotoService;
    private final ProductVariantService productVariantService;
    private final ProductCommentService productCommentService;
    private final AddressService addressService;
    private final AdminUserService adminUserService;
    private final ProfileService profileService;
    private final AgreementsAndStringsService agreementsAndStringsService;
    private final BankAccountService bankAccountService;
    private final BannerService bannerService;
    private final CargoCompanyService cargoCompanyService;
    private final FaqService faqService;
    private final IyzicoService iyzicoService;
    private final OrderNoticeService orderNoticeService;
    private final SettingService settingService;
    private final Faker faker = new Faker(new Locale("tr"));

    @Value("${aws.s3.bucket.public.address}")
    private String bucketAddress;

    String[] productPics = {
            "09dd86717727c51809019d98501a1.png",
            "09dd86717727c51809019d98501a2.png",
            "09dd86717727c51809019d98501a3.png",
            "09dd86717727c51809019d98501a4.png",
            "0fc37e18f99b0c199ea7dd469898f57d1195.png",
            "0fc37e18f99b0c199ea7dd469898f57d1197.png",
            "0fc37e18f99b0c199ea7dd469898f57d1279.png",
            "0fc37e18f99b0c199ea7dd469898f57d7164.png",
            "124a0743e639b0800a978a7aa5b0ae191.png",
            "124a0743e639b0800a978a7aa5b0ae192.png",
            "124a0743e639b0800a978a7aa5b0ae193.png",
            "124a0743e639b0800a978a7aa5b0ae196.png",
            "14611c57d906dbb1ee595c877489d3c81000.png",
            "14611c57d906dbb1ee595c877489d3c82917.png",
            "15feb2d8f3259ff9b3beef74cfcbb4901.png",
            "15feb2d8f3259ff9b3beef74cfcbb4902.png",
            "15feb2d8f3259ff9b3beef74cfcbb4903.png",
            "15feb2d8f3259ff9b3beef74cfcbb4904.png",
            "18ae2d6b36b336deb22c89cf37628e5d4407.png",
            "18ae2d6b36b336deb22c89cf37628e5d7346.png",
            "18ae2d6b36b336deb22c89cf37628e5d8666.png",
            "18ae2d6b36b336deb22c89cf37628e5d9958.png",
            "28937a01424f2393db5c102110bcff023751.png",
            "28937a01424f2393db5c102110bcff026505.png",
            "3380841b44793b60fddec584b2493dbc1250.png",
            "3380841b44793b60fddec584b2493dbc2323.png",
            "3380841b44793b60fddec584b2493dbc3140.png",
            "3380841b44793b60fddec584b2493dbc4002.png",
            "33ce21dd1a861bcded330e076ba6d53600.png",
            "33ce21dd1a861bcded330e076ba6d5361071.png",
            "33ce21dd1a861bcded330e076ba6d5367148.png",
            "33ce21dd1a861bcded330e076ba6d5367199.png",
            "35e0c413a964c289405c2cf095b0fb661.png",
            "35e0c413a964c289405c2cf095b0fb662.png",
            "35e0c413a964c289405c2cf095b0fb663.png",
            "35e0c413a964c289405c2cf095b0fb664.png",
            "38054d19915ae638542bceb6e79dca2c2100.png",
            "38054d19915ae638542bceb6e79dca2c2644.png",
            "38054d19915ae638542bceb6e79dca2c3773.png",
            "38054d19915ae638542bceb6e79dca2c3786.png",
            "4c0086dc40e6f9e81a8d4e64bcb71bd5000.png",
            "4c0086dc40e6f9e81a8d4e64bcb71bd5425.png",
            "4c0086dc40e6f9e81a8d4e64bcb71bd5998.png",
            "4c0086dc40e6f9e81a8d4e64bcb71bd5999.png",
            "5a43fd84079ee1bda117e535f76eeee1.png",
            "5a43fd84079ee1bda117e535f76eeee2.png",
            "5a43fd84079ee1bda117e535f76eeee3.png",
            "5a43fd84079ee1bda117e535f76eeee4.png",
            "5c9ae70710a57bf6bf437d0648b17cc1.png",
            "5c9ae70710a57bf6bf437d0648b17cc2.png",
            "5c9ae70710a57bf6bf437d0648b17cc3.png",
            "5c9ae70710a57bf6bf437d0648b17cc4.png",
            "6d7d200aa7f545da0db6edbb391382a1.png",
            "6d7d200aa7f545da0db6edbb391382a2.png",
            "6d7d200aa7f545da0db6edbb391382a3.png",
            "6d7d200aa7f545da0db6edbb391382a64239.png",
            "88842b8c9337f8aa477c89bf5b8fed211111.png",
            "88842b8c9337f8aa477c89bf5b8fed221111.png",
            "88842b8c9337f8aa477c89bf5b8fed233333.png",
            "88842b8c9337f8aa477c89bf5b8fed244444.png",
            "8ffa2d9b8eb89724e0fc177503fa1.png",
            "8ffa2d9b8eb89724e0fc177503fa2.png",
            "8ffa2d9b8eb89724e0fc177503fa3.png",
            "8ffa2d9b8eb89724e0fc177503fa4.png",
            "976bb87e1613c4e2e715bf28be977beb2462.png",
            "976bb87e1613c4e2e715bf28be977beb5215.png",
            "976bb87e1613c4e2e715bf28be977beb8789.png",
            "976bb87e1613c4e2e715bf28be977beb9999.png",
            "97e82a6f71d3d8f29ad50cbe4a9b82521007.png",
            "97e82a6f71d3d8f29ad50cbe4a9b82522400.png",
            "97e82a6f71d3d8f29ad50cbe4a9b82522646.png",
            "97e82a6f71d3d8f29ad50cbe4a9b82529999.png",
            "9e33bcb75cf51a8a87a3f89e5612615d1.png",
            "9e33bcb75cf51a8a87a3f89e5612615d2.png",
            "9e33bcb75cf51a8a87a3f89e5612615d3.png",
            "9e33bcb75cf51a8a87a3f89e5612615d4.png",
            "c4b96945ebbd0be76773fb10cf74d55e7370.png",
            "c4b96945ebbd0be76773fb10cf74d55e8229.png",
            "c4b96945ebbd0be76773fb10cf74d55e9429.png",
            "c4b96945ebbd0be76773fb10cf74d9999999.png",
            "ca44691e8a6e97e7fc5c52d3cce3f26d141.png",
            "ca44691e8a6e97e7fc5c52d3cce3f26d7093.png",
            "efc09ea225942fd3802c3000f1215f151018.png",
            "efc09ea225942fd3802c3000f1215f158909.png"
    };

    @Autowired
    public DbSeederController(PlatformUserService platformUserService, ProductService productService, CategoryService categoryService, ProductPhotoService productPhotoService, ProductVariantService productVariantService, ProductCommentService productCommentService, AddressService addressService, AdminUserService adminUserService, ProfileService profileService, AgreementsAndStringsService agreementsAndStringsService, BankAccountService bankAccountService, BannerService bannerService, CargoCompanyService cargoCompanyService, FaqService faqService, IyzicoService iyzicoService, OrderNoticeService orderNoticeService, SettingService settingService) {
        this.platformUserService = platformUserService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.productPhotoService = productPhotoService;
        this.productVariantService = productVariantService;
        this.productCommentService = productCommentService;
        this.addressService = addressService;
        this.adminUserService = adminUserService;
        this.profileService = profileService;
        this.agreementsAndStringsService = agreementsAndStringsService;
        this.bankAccountService = bankAccountService;
        this.bannerService = bannerService;
        this.cargoCompanyService = cargoCompanyService;
        this.faqService = faqService;
        this.iyzicoService = iyzicoService;
        this.orderNoticeService = orderNoticeService;
        this.settingService = settingService;
    }

    @PostMapping("seed")
    public void seedTheDatabase(@RequestBody DatabaseSeederDto databaseSeederDto) {
        int numberOfCategoryToBeCreated = databaseSeederDto.getNumberOfCategoryToBeCreated();
        int numberOfUserToBeCreated = databaseSeederDto.getNumberOfUserToBeCreated();
        int numberOfProductsToBeCreated = databaseSeederDto.getNumberOfProductsToBeCreated();
        int numberOfOrderNoticeToBeCreated = databaseSeederDto.getNumberOfOrderNoticeToBeCreated();

        this.createCategory(numberOfCategoryToBeCreated);
        this.createUser(numberOfUserToBeCreated);
        this.createAdmin();
        this.createAgreementsAndStrings();
        this.createBankAccounts();
        this.createBanners();
        this.createCargoCompany();
        this.createFaqs();
        this.createIyzico();
        this.createOrderNotices(numberOfOrderNoticeToBeCreated);
        this.createSetting();

        for (int i = 0; i < numberOfProductsToBeCreated; i++ ){
            //for each product
            Product product = new Product();

            product.setCargoPrice(ThreadLocalRandom.current().nextInt(1,  1000));
            product.setCreatedAt(new Date());
            product.setDescription(this.faker.lorem().sentence(ThreadLocalRandom.current().nextInt(1,  10)));
            product.setDeleted(false);
            product.setName(this.faker.lorem().sentence(2));
            product.setPrice(ThreadLocalRandom.current().nextInt(1,  10000));
            product.setTax(18);
            product.setVariantTitle("Size");
            product.setView(0);

            //select random elements on your category list and add them your product
            List<Category> categories = new ArrayList<>();

            for (int j = 0; j < 4; j++) {
                categories.add(this.categoryService.getRandom());
            }

            product.setCategories(categories);

            this.productService.save(product);

            this.setProductPhotos(product);
            this.setComments(product);
            this.setVariants(product);
            this.setLikes(product);

            this.productService.save(product);

            System.out.println(product);
        }
    }

    private void createSetting() {
        Setting setting = new Setting();

        setting.setAddress(this.faker.address().fullAddress());
        setting.setDescription(this.faker.lorem().sentence(3));
        setting.setName("Spring Shop");
        setting.setCopyright("2021 All Rights Reserved");
        setting.setFooterText(this.faker.lorem().sentence(5));
        setting.setFacebook("facebook");
        setting.setLinkedin("linkedin");
        setting.setInstagram("instagram");
        setting.setPinterest("pinterest");
        setting.setTwitter("twitter");
        setting.setYoutube("youtube");
        setting.setLink("localhost");
        setting.setKeywords("shop, spring");
        setting.setPhone(this.faker.phoneNumber().phoneNumber());
        setting.setTitle(this.faker.lorem().word());
        setting.setMail(this.faker.internet().emailAddress());

        this.settingService.save(setting);
    }

    private void createOrderNotices(int numberOfOrderNoticeToBeCreated) {
        for (int i = 0; i< numberOfOrderNoticeToBeCreated; i++){
            OrderNotice orderNotice = new OrderNotice();
            orderNotice.setEmail(this.faker.internet().emailAddress());
            orderNotice.setCreatedAt(new Date());
            orderNotice.setMobile(this.faker.phoneNumber().cellPhone());
            orderNotice.setName(this.faker.name().fullName());
            Random random = new Random();
            orderNotice.setApproved(random.nextBoolean());
            orderNotice.setMessage(this.faker.lorem().sentence(15));
            orderNotice.setDeleted(random.nextBoolean());
            BankAccount bankAccount = this.bankAccountService.getFirst();
            orderNotice.setBankAccount(bankAccount);
            this.orderNoticeService.save(orderNotice);
        }
    }

    private void createIyzico() {
        Iyzico iyzico = new Iyzico();
        iyzico.setApiKey("api");
        iyzico.setBaseUrl("base");
        iyzico.setSecretKey("secret");
        this.iyzicoService.save(iyzico);
    }

    private void createFaqs() {
        Faq faq = new Faq();
        faq.setQuestion(this.faker.lorem().sentence(6));
        faq.setAnswer(this.faker.lorem().sentence(9));
        this.faqService.save(faq);
    }

    private void createCargoCompany() {
        CargoCompany cargoCompany = new CargoCompany();
        cargoCompany.setName("Aras Kargo");
        this.cargoCompanyService.save(cargoCompany);
    }

    private void createBanners() {
        Banner banner = new Banner();
        banner.setName("firts-banner");
        banner.setPath("banner.png");
        banner.setNumberOfShow(0);
        this.bannerService.save(banner);
    }

    private void createBankAccounts() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setName("Akbank");
        bankAccount.setAccountNumber("12312312332");
        bankAccount.setCity(this.faker.address().city());
        bankAccount.setAccountOwner(this.faker.name().fullName());
        bankAccount.setBranchCode("11223344");
        bankAccount.setCountry(this.faker.address().country());
        bankAccount.setBranchName(this.faker.lorem().word());
        bankAccount.setCurrency("TRY");
        bankAccount.setIban("TR750006274789839532261931");
        bankAccount.setLogo("logo.png");
        this.bankAccountService.save(bankAccount);
    }

    private void createAgreementsAndStrings() {
        AgreementsAndStrings agreementsAndStrings = new AgreementsAndStrings();

        agreementsAndStrings.setSignUpAgreement("Sign Up Agreement <br> "+this.faker.lorem().sentence(10));
        agreementsAndStrings.setConfidentialityAgreement("Confidentiality Agreement <br> "+this.faker.lorem().sentence(10));
        agreementsAndStrings.setAboutUs("About Us <br> "+this.faker.lorem().sentence(10));
        agreementsAndStrings.setDistantSalesAgreement("Distant Sales Agreement <br> "+this.faker.lorem().sentence(10));
        agreementsAndStrings.setDeliverables("Deliverables <br> "+this.faker.lorem().sentence(10));
        agreementsAndStrings.setCancelRefundChange("Cancel Refund Change <br> "+this.faker.lorem().sentence(10));
        agreementsAndStrings.setTermsOfUse("Terms of use <br> "+this.faker.lorem().sentence(10));

        this.agreementsAndStringsService.save(agreementsAndStrings);
    }

    private void createAdmin() {
        AdminUser adminUser = new AdminUser();

        adminUser.setDeleted(false);
        adminUser.setEmail("admin@admin.com");
        adminUser.setName("Super");
        adminUser.setSurname("Admin");
        adminUser.setMobile(this.faker.phoneNumber().cellPhone());
        adminUser.setPassword(this.hashString("123123aa"));

        List<Profile> profiles = new ArrayList<>();
        Profile profile = new Profile();
        profile.setName("GM");
        this.profileService.save(profile);

        profiles.add(profile);
        adminUser.setProfiles(profiles);

        this.adminUserService.save(adminUser);
    }

    public void createCategory(int quantity){
        //create 15 categories
        for (int i = 0; i <= quantity; i++){
            Category category = new Category();
            category.setName(this.faker.lorem().word());
            this.categoryService.save(category);
        }
    }

    public String hashString(String password) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    public List<ProductPhoto> getProductPhotos(){
        List<ProductPhoto> productPhotos = new ArrayList<>();

        for (String path:this.productPics) {
            ProductPhoto productPhoto = new ProductPhoto();
            productPhoto.setPath(this.bucketAddress+path);
            productPhoto.setDeleted(false);
            productPhotos.add(productPhoto);
        }
        return productPhotos;
    }

    public void setProductPhotos(Product product){
        //add photos
        List<ProductPhoto> allProductPhotos = this.getProductPhotos();

        ProductPhoto productPhoto1;
        ProductPhoto productPhoto2;
        ProductPhoto productPhoto3;
        ProductPhoto productPhoto4;

        productPhoto1 = allProductPhotos.get(ThreadLocalRandom.current().nextInt(1,  allProductPhotos.size()));
        productPhoto2 = allProductPhotos.get(ThreadLocalRandom.current().nextInt(1,  allProductPhotos.size()));
        productPhoto3 = allProductPhotos.get(ThreadLocalRandom.current().nextInt(1,  allProductPhotos.size()));
        productPhoto4 = allProductPhotos.get(ThreadLocalRandom.current().nextInt(1,  allProductPhotos.size()));

        productPhoto1.setProduct(product);
        productPhoto2.setProduct(product);
        productPhoto3.setProduct(product);
        productPhoto4.setProduct(product);

        //save db
        this.productPhotoService.save(productPhoto1);
        this.productPhotoService.save(productPhoto2);
        this.productPhotoService.save(productPhoto3);
        this.productPhotoService.save(productPhoto4);
    }

    public void setVariants(Product product) {
        ProductVariant variant1 = new ProductVariant();
        ProductVariant variant2 = new ProductVariant();
        ProductVariant variant3 = new ProductVariant();

        variant1.setName("Small");
        variant1.setStock(12);
        variant1.setProduct(product);
        variant2.setName("Large");
        variant2.setStock(12);
        variant2.setProduct(product);
        variant3.setName("Medium");
        variant3.setStock(12);
        variant3.setProduct(product);

        this.productVariantService.save(variant1);
        this.productVariantService.save(variant2);
        this.productVariantService.save(variant3);
    }

    public void setLikes(Product product){
        PlatformUser platformUser1 = this.platformUserService.getRandom();
        PlatformUser platformUser2 = this.platformUserService.getRandom();
        PlatformUser platformUser3 = this.platformUserService.getRandom();

        List<Product> products = new ArrayList<>();

        products.add(product);

        platformUser1.setFavoriteProducts(products);
        platformUser2.setFavoriteProducts(products);
        platformUser3.setFavoriteProducts(products);

        this.platformUserService.save(platformUser1);
        this.platformUserService.save(platformUser2);
        this.platformUserService.save(platformUser3);
    }

    public void setComments(Product product){
        for (int i = 0; i <= 10; i++){

            ProductComment productComment = new ProductComment();

            productComment.setComment(this.faker.lorem().sentence(ThreadLocalRandom.current().nextInt(1,  10)));
            productComment.setCreatedAt(new Date());
            productComment.setDeleted(false);
            productComment.setIpAddress(this.faker.internet().ipV4Address());
            productComment.setRate(ThreadLocalRandom.current().nextInt(1,  10));
            productComment.setPlatformUser(this.platformUserService.getRandom());
            productComment.setProduct(product);

            this.productCommentService.save(productComment);
        }
    }

    public void createUser(@RequestParam int quantity) {

        for (int i=0;i<=quantity;i++){

            List<Address> addresses = new ArrayList<>();
            for (int j=0; j <= 3 ; j++){
                Address address = new Address();
                address.setAddress(this.faker.address().fullAddress());
                address.setName(this.faker.funnyName().name());
                address.setMobile(this.faker.phoneNumber().cellPhone());
                address.setCity(this.faker.address().city());
                address.setCounty(this.faker.address().country());
                address.setRecipient(this.faker.name().fullName());

                addresses.add(address);
                this.addressService.save(address);
            }

            PlatformUser platformUser = new PlatformUser();

            platformUser.setName(this.faker.name().firstName());
            platformUser.setSurname(this.faker.name().lastName());
            platformUser.setEmail(this.faker.internet().emailAddress());
            platformUser.setPassword(this.hashString("123123aa"));
            platformUser.setDeleted(false);
            platformUser.setMobile(this.faker.phoneNumber().cellPhone());
            platformUser.setActivationCode(this.faker.random().toString());
            platformUser.setIpAddress(this.faker.internet().ipV4Address());
            platformUser.setEmailApproved(true);
            platformUser.setMobileApproved(true);
            platformUser.setUnsubscribe(false);
            platformUser.setCreatedAt(new Date());

            this.platformUserService.save(platformUser);

            for (Address address : addresses){
                address.setPlatformUser(platformUser);
                this.addressService.save(address);
            }
        }
    }
}
