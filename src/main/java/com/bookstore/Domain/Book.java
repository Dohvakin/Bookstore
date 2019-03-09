package com.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

/**
 * The type Book.
 */
@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String author;
	private String publisher;
	private String publicationDate;
	private String language;
	private String category;
	private int numberOfPages;
	private String format;
	private int isbn;
	private double shippingWeight;
	private double listPrice;
	private double ourPrice;
	private boolean active = true;

	@Column(columnDefinition = "text")
	private String description;
	private int inStockNumber;

	@Transient
	private MultipartFile bookImage;

	@OneToMany(mappedBy = "book")
	@JsonIgnore
	private List<BookToCartItem> bookToCartItemList;

	/**
	 * Gets id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets title.
	 *
	 * @param title the title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets author.
	 *
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets author.
	 *
	 * @param author the author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Gets publisher.
	 *
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * Sets publisher.
	 *
	 * @param publisher the publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * Gets publication date.
	 *
	 * @return the publication date
	 */
	public String getPublicationDate() {
		return publicationDate;
	}

	/**
	 * Sets publication date.
	 *
	 * @param publicationDate the publication date
	 */
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	/**
	 * Gets language.
	 *
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Sets language.
	 *
	 * @param language the language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Gets category.
	 *
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets category.
	 *
	 * @param category the category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Gets number of pages.
	 *
	 * @return the number of pages
	 */
	public int getNumberOfPages() {
		return numberOfPages;
	}

	/**
	 * Sets number of pages.
	 *
	 * @param numberOfPages the number of pages
	 */
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	/**
	 * Gets format.
	 *
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * Sets format.
	 *
	 * @param format the format
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * Gets isbn.
	 *
	 * @return the isbn
	 */
	public int getIsbn() {
		return isbn;
	}

	/**
	 * Sets isbn.
	 *
	 * @param isbn the isbn
	 */
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	/**
	 * Gets shipping weight.
	 *
	 * @return the shipping weight
	 */
	public double getShippingWeight() {
		return shippingWeight;
	}

	/**
	 * Sets shipping weight.
	 *
	 * @param shippingWeight the shipping weight
	 */
	public void setShippingWeight(double shippingWeight) {
		this.shippingWeight = shippingWeight;
	}

	/**
	 * Gets list price.
	 *
	 * @return the list price
	 */
	public double getListPrice() {
		return listPrice;
	}

	/**
	 * Sets list price.
	 *
	 * @param listPrice the list price
	 */
	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

	/**
	 * Gets our price.
	 *
	 * @return the our price
	 */
	public double getOurPrice() {
		return ourPrice;
	}

	/**
	 * Sets our price.
	 *
	 * @param ourPrice the our price
	 */
	public void setOurPrice(double ourPrice) {
		this.ourPrice = ourPrice;
	}

	/**
	 * Is active boolean.
	 *
	 * @return the boolean
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets active.
	 *
	 * @param active the active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Gets description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets description.
	 *
	 * @param description the description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets in stock number.
	 *
	 * @return the in stock number
	 */
	public int getInStockNumber() {
		return inStockNumber;
	}

	/**
	 * Sets in stock number.
	 *
	 * @param inStockNumber the in stock number
	 */
	public void setInStockNumber(int inStockNumber) {
		this.inStockNumber = inStockNumber;
	}

	/**
	 * Gets book image.
	 *
	 * @return the book image
	 */
	public MultipartFile getBookImage() {
		return bookImage;
	}

	/**
	 * Sets book image.
	 *
	 * @param bookImage the book image
	 */
	public void setBookImage(MultipartFile bookImage) {
		this.bookImage = bookImage;
	}

	/**
	 * Gets book to cart item list.
	 *
	 * @return the book to cart item list
	 */
	public List<BookToCartItem> getBookToCartItemList() {
		return bookToCartItemList;
	}

	/**
	 * Sets book to cart item list.
	 *
	 * @param bookToCartItemList the book to cart item list
	 */
	public void setBookToCartItemList(List<BookToCartItem> bookToCartItemList) {
		this.bookToCartItemList = bookToCartItemList;
	}
}
