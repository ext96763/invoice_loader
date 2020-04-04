package com.bj.invoiceLoader.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Invoice {
    @Id
    private String custom_id;
    private Integer id;    //identifikátor faktury	integer, readonly
    private boolean proforma;//	příznak proformy - true/false	boolean, optional, default: false
    private boolean partial_proforma;//	přiznak zda je proforma na plnou částku - true/false	boolean, optional, default: false
    private String number;    //číslo faktury (Př: 2011-0001, musí odpovídat formátu čísla v nastavení účtu)	string, optional, unique
    private String variable_symbol;    //variabilní symbol (nepovinné - doplní se z čísla faktury)	string, optional, default: by invoice number
    private String your_name; //název vaší firmy	string, readonly
    private String your_street; //vaše ulice	string, readonly
    private String your_street2;    //vaše ulice 2	string, readonly
    private String your_city;    //vaše město	string, readonly
    private String your_zip; //vaše poštovní směrovací číslo	string, readonly
    private String your_country;    //vaše země (ISO kód)	string, readonly
    private String your_registration_no;//	vaše IČ	string, readonly
    private String your_vat_no;//	vaše DIČ	string, readonly
    private String your_local_vat_no;//	vaše SK DIČ (pouze pro Slovensko, nezačíná kódem země)	string, readonly
    private String client_name;//	název firmy kontaktu	string, readonly
    private String client_street;//	ulice kontatku	string, readonly
    private String client_street2;//	ulice 2 kontaktu	string, readonly
    private String client_city;//	město kontaktu	string, readonly
    private String client_zip;//	poštovní směrovací číslo kontaktu	string, readonly
    private String client_country;//	země kontaktu (ISO kód)	string, readonly
    private String client_registration_no;//	IČ kontaktu	string, readonly
    private String client_vat_no;//	DIČ kontaktu	string, readonly
    private String client_local_vat_no;//	SK DIČ kontaktu (pouze pro Slovensko, nezačíná kódem země)	string, readonly
    private Integer subject_id;//	ID kontaktu (povinné)	integer, required
    private String subject_custom_id;//	identifikátor kontaktu ve vaší aplikaci	integer, optional
    private Integer generator_id;//	ID;// šablony ze které byla faktura vystavena	integer, optional
    private Integer related_id;//	ID proformy/faktury (u faktur vystavených ze zálohových faktur)	integer, optional
    private boolean correction;//	true - Opravný daňový doklad, false - faktura/proforma	boolean, optional, default: false
    private Integer correction_id;//	ID opravovaného dokladu, zadává se pouze pokud je correction=true, na opravovaný doklad se automaticky doplní ID opravného daňového dokladu	integer, optional
    private String token;//	token pro public akci	string, readonly
    private String status;//	stav faktury - open/sent/overdue/paid/cancelled	string, readonly
    private String order_number;//	číslo objednávky (nepovinné)	string, optional
    private Date issued_on;//	datum vystavení (zobrazeno na faktuře)	date, optional, default: today
    private Date taxable_fulfillment_due;//	datum zdanitelného plnění	date, optional, default: today
    private Integer due;//	počet dní, než bude po splatnosti (nepovinné - doplní se z účtu)	integer, optional, default: by account settings
    private Date due_on;//	datum splatnosti (doplní se podle due)	date, readonly
    //TODO datetime format
    private Date sent_at;//	datum a čas odeslání faktury	datetime, readonly
    private Date paid_at;//	datum a čas zaplacení faktury	datetime, readonly
    private Date reminder_sent_at;//	datum a čas odeslání upomínky	datetime, readonly
    private Date accepted_at;//	datum a čas odsouhlasení faktury klientem	datetime, readonly
    private Date cancelled_at;//	datum stornování faktury (pouze pro neplátce DPH)	datetime, readonly
    private String note;//	text před položkami faktury (nepovinné - doplní se z účtu)	string, optional, default: by account settings
    private String footer_note;//	patička faktury (nepovinné - doplní se z účtu)	string, optional, default: by account settings
    private String private_note;//	soukromá poznámka (nepovinné)	string, optional

    @ElementCollection
    private List<String> seznam;// tagů faktury	array, optional
    private Integer bank_account_id;//	ID bankovního účtu (nepovinné - použije se výchozí bankovní účet)	integer, only on create action, optional
    private String bank_account;//	číslo bankovního účtu (nepovinné - použije se výchozí bankovní účet)	string, optional, default: by account settings
    private String iban;//	IBAN (nepovinné - doplní se z účtu)	string, optional, default: by account settings
    private String swift_bic;//	BIC (nepovinné - doplní se z účtu)	string, optional, default: by account settings
    private String payment_method;//	bank (bankovní převod) / cash (hotově) / cod (dobírka) / paypal (PayPal) / card (Karta)	string, optional, default: bank
    private String currency;//	kód měny (nepovinné - doplní se z účtu, 3 znaky)	string, optional, default: by account settings
    private String exchange_rate;//	kurz (povinný pokud je měna faktury jiná než měna účtu)	string, optional
    private boolean paypal;//	tlačítko pro platbu PayPalem - true/false	boolean, optional, default: false
    private boolean gopay;//	tlačítko pro platbu přes GoPay - true/false	boolean, optional, default: false
    private String language;//	jazyk faktury (cz, sk, en, de, fr, it, es, ru, pl)	string, optional, default: cz
    private boolean transferred_tax_liability;//	přenesená daňová povinnost true/false	boolean, optional, default: false
    private Integer supply_code;//	kód plnění pro souhrnná hlášení (pouze pro zahraniční faktury do EU)	integer, optional
    private boolean eu_electronic_service;//	příznak, pokud je faktura v režimu MOSS	boolean, optional, default: false
    private String vat_price_mode;//	způsob zadávání cen do řádků	string, values: null, without_vat, with_vat, default: by account settings
    private boolean round_total;//	zaokrouhlit cenu s DPH (při vystavení)	boolean, optional, default: false
    private BigDecimal subtotal;//	součet (bez DPH)	BigDecimal, readonly
    private BigDecimal native_subtotal;//	součet v měně účtu	BigDecimal, readonly
    private BigDecimal total;//	celkový součet (včetně DPH)	BigDecimal, readonly
    private BigDecimal native_total;//	součet v měně účtu (včetně DPH)	BigDecimal, readonly
    private BigDecimal remaining_amount;//	částka k zaplacení (včetně DPH)	BigDecimal, readonly
    private BigDecimal remaining_native_amount;//	částka k zaplacení v měně účtu (včetně DPH)	BigDecimal, readonly
    private BigDecimal paid_amount;//	skutečně zaplacená částka	BigDecimal, readonly
    private boolean eet;//	příznak jestli je faktura evidovaná v EET (více v článku na podpoře EET pro vývojáře)	boolean, optional, default: false
    private String eet_cash_register;//	pokladna	string, optional, default: null
    private Integer eet_store;//	číslo provozovny	integer, optional, default: null
    @ElementCollection
    private List<String> eet_records;//	EET záznamy	array, optional, default: []

    private String attachment;//	příloha	object, optional
    private String html_url;//	HTML adresa faktury	string, readonly
    private String public_html_url;//	veřejná HTML adresa faktury	string, readonly
    private String url;//	API adresa faktury	string, readonly
    private String pdf_url;//	API adresa pro stažení faktury v PDF	string, readonly
    private String subject_url;//	API adresa kontaktu	string, readonly
    private Date created_at;//	datum vytvoření faktury	datetime, readonly
    private Date updated_at;//	datum poslední aktualizace faktury	datetime, readonly

    //@ElementCollection(targetClass = InvoiceFull.class)
    @OneToMany(mappedBy = "customId", cascade = {CascadeType.MERGE})
    private List<Line> lines;

    public Invoice() {
    }

    public Invoice(String custom_id, Integer id, boolean proforma, boolean partial_proforma, String number, String variable_symbol, String your_name, String your_street, String your_street2, String your_city, String your_zip, String your_country, String your_registration_no, String your_vat_no, String your_local_vat_no, String client_name, String client_street, String client_street2, String client_city, String client_zip, String client_country, String client_registration_no, String client_vat_no, String client_local_vat_no, Integer subject_id, String subject_custom_id, Integer generator_id, Integer related_id, boolean correction, Integer correction_id, String token, String status, String order_number, Date issued_on, Date taxable_fulfillment_due, Integer due, Date due_on, Date sent_at, Date paid_at, Date reminder_sent_at, Date accepted_at, Date cancelled_at, String note, String footer_note, String private_note, List<String> seznam, Integer bank_account_id, String bank_account, String iban, String swift_bic, String payment_method, String currency, String exchange_rate, boolean paypal, boolean gopay, String language, boolean transferred_tax_liability, Integer supply_code, boolean eu_electronic_service, String vat_price_mode, boolean round_total, BigDecimal subtotal, BigDecimal native_subtotal, BigDecimal total, BigDecimal native_total, BigDecimal remaining_amount, BigDecimal remaining_native_amount, BigDecimal paid_amount, boolean eet, String eet_cash_register, Integer eet_store, List<String> eet_records, String attachment, String html_url, String public_html_url, String url, String pdf_url, String subject_url, Date created_at, Date updated_at, List<Line> lines) {
        this.custom_id = custom_id;
        this.id = id;
        this.proforma = proforma;
        this.partial_proforma = partial_proforma;
        this.number = number;
        this.variable_symbol = variable_symbol;
        this.your_name = your_name;
        this.your_street = your_street;
        this.your_street2 = your_street2;
        this.your_city = your_city;
        this.your_zip = your_zip;
        this.your_country = your_country;
        this.your_registration_no = your_registration_no;
        this.your_vat_no = your_vat_no;
        this.your_local_vat_no = your_local_vat_no;
        this.client_name = client_name;
        this.client_street = client_street;
        this.client_street2 = client_street2;
        this.client_city = client_city;
        this.client_zip = client_zip;
        this.client_country = client_country;
        this.client_registration_no = client_registration_no;
        this.client_vat_no = client_vat_no;
        this.client_local_vat_no = client_local_vat_no;
        this.subject_id = subject_id;
        this.subject_custom_id = subject_custom_id;
        this.generator_id = generator_id;
        this.related_id = related_id;
        this.correction = correction;
        this.correction_id = correction_id;
        this.token = token;
        this.status = status;
        this.order_number = order_number;
        this.issued_on = issued_on;
        this.taxable_fulfillment_due = taxable_fulfillment_due;
        this.due = due;
        this.due_on = due_on;
        this.sent_at = sent_at;
        this.paid_at = paid_at;
        this.reminder_sent_at = reminder_sent_at;
        this.accepted_at = accepted_at;
        this.cancelled_at = cancelled_at;
        this.note = note;
        this.footer_note = footer_note;
        this.private_note = private_note;
        this.seznam = seznam;
        this.bank_account_id = bank_account_id;
        this.bank_account = bank_account;
        this.iban = iban;
        this.swift_bic = swift_bic;
        this.payment_method = payment_method;
        this.currency = currency;
        this.exchange_rate = exchange_rate;
        this.paypal = paypal;
        this.gopay = gopay;
        this.language = language;
        this.transferred_tax_liability = transferred_tax_liability;
        this.supply_code = supply_code;
        this.eu_electronic_service = eu_electronic_service;
        this.vat_price_mode = vat_price_mode;
        this.round_total = round_total;
        this.subtotal = subtotal;
        this.native_subtotal = native_subtotal;
        this.total = total;
        this.native_total = native_total;
        this.remaining_amount = remaining_amount;
        this.remaining_native_amount = remaining_native_amount;
        this.paid_amount = paid_amount;
        this.eet = eet;
        this.eet_cash_register = eet_cash_register;
        this.eet_store = eet_store;
        this.eet_records = eet_records;
        this.attachment = attachment;
        this.html_url = html_url;
        this.public_html_url = public_html_url;
        this.url = url;
        this.pdf_url = pdf_url;
        this.subject_url = subject_url;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.lines = lines;
    }

    public String getCustom_id() {
        return custom_id;
    }

    public void setCustom_id(String custom_id) {
        this.custom_id = custom_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isProforma() {
        return proforma;
    }

    public void setProforma(boolean proforma) {
        this.proforma = proforma;
    }

    public boolean isPartial_proforma() {
        return partial_proforma;
    }

    public void setPartial_proforma(boolean partial_proforma) {
        this.partial_proforma = partial_proforma;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getVariable_symbol() {
        return variable_symbol;
    }

    public void setVariable_symbol(String variable_symbol) {
        this.variable_symbol = variable_symbol;
    }

    public String getYour_name() {
        return your_name;
    }

    public void setYour_name(String your_name) {
        this.your_name = your_name;
    }

    public String getYour_street() {
        return your_street;
    }

    public void setYour_street(String your_street) {
        this.your_street = your_street;
    }

    public String getYour_street2() {
        return your_street2;
    }

    public void setYour_street2(String your_street2) {
        this.your_street2 = your_street2;
    }

    public String getYour_city() {
        return your_city;
    }

    public void setYour_city(String your_city) {
        this.your_city = your_city;
    }

    public String getYour_zip() {
        return your_zip;
    }

    public void setYour_zip(String your_zip) {
        this.your_zip = your_zip;
    }

    public String getYour_country() {
        return your_country;
    }

    public void setYour_country(String your_country) {
        this.your_country = your_country;
    }

    public String getYour_registration_no() {
        return your_registration_no;
    }

    public void setYour_registration_no(String your_registration_no) {
        this.your_registration_no = your_registration_no;
    }

    public String getYour_vat_no() {
        return your_vat_no;
    }

    public void setYour_vat_no(String your_vat_no) {
        this.your_vat_no = your_vat_no;
    }

    public String getYour_local_vat_no() {
        return your_local_vat_no;
    }

    public void setYour_local_vat_no(String your_local_vat_no) {
        this.your_local_vat_no = your_local_vat_no;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_street() {
        return client_street;
    }

    public void setClient_street(String client_street) {
        this.client_street = client_street;
    }

    public String getClient_street2() {
        return client_street2;
    }

    public void setClient_street2(String client_street2) {
        this.client_street2 = client_street2;
    }

    public String getClient_city() {
        return client_city;
    }

    public void setClient_city(String client_city) {
        this.client_city = client_city;
    }

    public String getClient_zip() {
        return client_zip;
    }

    public void setClient_zip(String client_zip) {
        this.client_zip = client_zip;
    }

    public String getClient_country() {
        return client_country;
    }

    public void setClient_country(String client_country) {
        this.client_country = client_country;
    }

    public String getClient_registration_no() {
        return client_registration_no;
    }

    public void setClient_registration_no(String client_registration_no) {
        this.client_registration_no = client_registration_no;
    }

    public String getClient_vat_no() {
        return client_vat_no;
    }

    public void setClient_vat_no(String client_vat_no) {
        this.client_vat_no = client_vat_no;
    }

    public String getClient_local_vat_no() {
        return client_local_vat_no;
    }

    public void setClient_local_vat_no(String client_local_vat_no) {
        this.client_local_vat_no = client_local_vat_no;
    }

    public Integer getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Integer subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_custom_id() {
        return subject_custom_id;
    }

    public void setSubject_custom_id(String subject_custom_id) {
        this.subject_custom_id = subject_custom_id;
    }

    public Integer getGenerator_id() {
        return generator_id;
    }

    public void setGenerator_id(Integer generator_id) {
        this.generator_id = generator_id;
    }

    public Integer getRelated_id() {
        return related_id;
    }

    public void setRelated_id(Integer related_id) {
        this.related_id = related_id;
    }

    public boolean isCorrection() {
        return correction;
    }

    public void setCorrection(boolean correction) {
        this.correction = correction;
    }

    public Integer getCorrection_id() {
        return correction_id;
    }

    public void setCorrection_id(Integer correction_id) {
        this.correction_id = correction_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public Date getIssued_on() {
        return issued_on;
    }

    public void setIssued_on(Date issued_on) {
        this.issued_on = issued_on;
    }

    public Date getTaxable_fulfillment_due() {
        return taxable_fulfillment_due;
    }

    public void setTaxable_fulfillment_due(Date taxable_fulfillment_due) {
        this.taxable_fulfillment_due = taxable_fulfillment_due;
    }

    public Integer getDue() {
        return due;
    }

    public void setDue(Integer due) {
        this.due = due;
    }

    public Date getDue_on() {
        return due_on;
    }

    public void setDue_on(Date due_on) {
        this.due_on = due_on;
    }

    public Date getSent_at() {
        return sent_at;
    }

    public void setSent_at(Date sent_at) {
        this.sent_at = sent_at;
    }

    public Date getPaid_at() {
        return paid_at;
    }

    public void setPaid_at(Date paid_at) {
        this.paid_at = paid_at;
    }

    public Date getReminder_sent_at() {
        return reminder_sent_at;
    }

    public void setReminder_sent_at(Date reminder_sent_at) {
        this.reminder_sent_at = reminder_sent_at;
    }

    public Date getAccepted_at() {
        return accepted_at;
    }

    public void setAccepted_at(Date accepted_at) {
        this.accepted_at = accepted_at;
    }

    public Date getCancelled_at() {
        return cancelled_at;
    }

    public void setCancelled_at(Date cancelled_at) {
        this.cancelled_at = cancelled_at;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getFooter_note() {
        return footer_note;
    }

    public void setFooter_note(String footer_note) {
        this.footer_note = footer_note;
    }

    public String getPrivate_note() {
        return private_note;
    }

    public void setPrivate_note(String private_note) {
        this.private_note = private_note;
    }

    public List<String> getSeznam() {
        return seznam;
    }

    public void setSeznam(List<String> seznam) {
        this.seznam = seznam;
    }

    public Integer getBank_account_id() {
        return bank_account_id;
    }

    public void setBank_account_id(Integer bank_account_id) {
        this.bank_account_id = bank_account_id;
    }

    public String getBank_account() {
        return bank_account;
    }

    public void setBank_account(String bank_account) {
        this.bank_account = bank_account;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getSwift_bic() {
        return swift_bic;
    }

    public void setSwift_bic(String swift_bic) {
        this.swift_bic = swift_bic;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getExchange_rate() {
        return exchange_rate;
    }

    public void setExchange_rate(String exchange_rate) {
        this.exchange_rate = exchange_rate;
    }

    public boolean isPaypal() {
        return paypal;
    }

    public void setPaypal(boolean paypal) {
        this.paypal = paypal;
    }

    public boolean isGopay() {
        return gopay;
    }

    public void setGopay(boolean gopay) {
        this.gopay = gopay;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isTransferred_tax_liability() {
        return transferred_tax_liability;
    }

    public void setTransferred_tax_liability(boolean transferred_tax_liability) {
        this.transferred_tax_liability = transferred_tax_liability;
    }

    public Integer getSupply_code() {
        return supply_code;
    }

    public void setSupply_code(Integer supply_code) {
        this.supply_code = supply_code;
    }

    public boolean isEu_electronic_service() {
        return eu_electronic_service;
    }

    public void setEu_electronic_service(boolean eu_electronic_service) {
        this.eu_electronic_service = eu_electronic_service;
    }

    public String getVat_price_mode() {
        return vat_price_mode;
    }

    public void setVat_price_mode(String vat_price_mode) {
        this.vat_price_mode = vat_price_mode;
    }

    public boolean isRound_total() {
        return round_total;
    }

    public void setRound_total(boolean round_total) {
        this.round_total = round_total;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getNative_subtotal() {
        return native_subtotal;
    }

    public void setNative_subtotal(BigDecimal native_subtotal) {
        this.native_subtotal = native_subtotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getNative_total() {
        return native_total;
    }

    public void setNative_total(BigDecimal native_total) {
        this.native_total = native_total;
    }

    public BigDecimal getRemaining_amount() {
        return remaining_amount;
    }

    public void setRemaining_amount(BigDecimal remaining_amount) {
        this.remaining_amount = remaining_amount;
    }

    public BigDecimal getRemaining_native_amount() {
        return remaining_native_amount;
    }

    public void setRemaining_native_amount(BigDecimal remaining_native_amount) {
        this.remaining_native_amount = remaining_native_amount;
    }

    public BigDecimal getPaid_amount() {
        return paid_amount;
    }

    public void setPaid_amount(BigDecimal paid_amount) {
        this.paid_amount = paid_amount;
    }

    public boolean isEet() {
        return eet;
    }

    public void setEet(boolean eet) {
        this.eet = eet;
    }

    public String getEet_cash_register() {
        return eet_cash_register;
    }

    public void setEet_cash_register(String eet_cash_register) {
        this.eet_cash_register = eet_cash_register;
    }

    public Integer getEet_store() {
        return eet_store;
    }

    public void setEet_store(Integer eet_store) {
        this.eet_store = eet_store;
    }

    public List<String> getEet_records() {
        return eet_records;
    }

    public void setEet_records(List<String> eet_records) {
        this.eet_records = eet_records;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getPublic_html_url() {
        return public_html_url;
    }

    public void setPublic_html_url(String public_html_url) {
        this.public_html_url = public_html_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPdf_url() {
        return pdf_url;
    }

    public void setPdf_url(String pdf_url) {
        this.pdf_url = pdf_url;
    }

    public String getSubject_url() {
        return subject_url;
    }

    public void setSubject_url(String subject_url) {
        this.subject_url = subject_url;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }
}
