/*
Navicat MySQL Data Transfer

Source Server         : Database
Source Server Version : 50152
Source Host           : localhost:3306
Source Database       : b_pos

Target Server Type    : MYSQL
Target Server Version : 50152
File Encoding         : 65001

Date: 2016-07-31 15:11:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `idCustomer` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `lanNo` varchar(45) DEFAULT NULL,
  `address01` varchar(45) DEFAULT NULL,
  `address02` varchar(45) DEFAULT NULL,
  `address03` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCustomer`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', 'bhagya', 'bhagyaperera142@gmail.com', '0719877863', '0719877863', 'no 58/1 ', 'galaudawatta,mahawadduwa', 'wadduwa', null);
INSERT INTO `customer` VALUES ('2', 'Nilanka', 'Nilankaperera1998@gmail.com', '0755511261', '075551043', 'no1', 'no2', 'no3', null);

-- ----------------------------
-- Table structure for `customerduerecords`
-- ----------------------------
DROP TABLE IF EXISTS `customerduerecords`;
CREATE TABLE `customerduerecords` (
  `idDueRecords` int(11) NOT NULL,
  `Datetime` varchar(45) DEFAULT NULL,
  `amount` varchar(45) DEFAULT NULL,
  `Customer_Due_idCustomer_Due` int(11) NOT NULL,
  PRIMARY KEY (`idDueRecords`),
  KEY `fk_CustomerDueRecords_Customer_Due1_idx` (`Customer_Due_idCustomer_Due`),
  CONSTRAINT `fk_CustomerDueRecords_Customer_Due1` FOREIGN KEY (`Customer_Due_idCustomer_Due`) REFERENCES `customer_due` (`idCustomer_Due`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customerduerecords
-- ----------------------------

-- ----------------------------
-- Table structure for `customer_due`
-- ----------------------------
DROP TABLE IF EXISTS `customer_due`;
CREATE TABLE `customer_due` (
  `idCustomer_Due` int(11) NOT NULL AUTO_INCREMENT,
  `Customer_idCustomer` int(11) NOT NULL,
  `Invoice_idInvoice` int(11) NOT NULL,
  `total` double DEFAULT NULL,
  `dueamount` double DEFAULT NULL,
  PRIMARY KEY (`idCustomer_Due`),
  KEY `fk_Customer_Due_Customer1_idx` (`Customer_idCustomer`),
  KEY `fk_Customer_Due_Invoice1_idx` (`Invoice_idInvoice`),
  CONSTRAINT `fk_Customer_Due_Customer1` FOREIGN KEY (`Customer_idCustomer`) REFERENCES `customer` (`idCustomer`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Customer_Due_Invoice1` FOREIGN KEY (`Invoice_idInvoice`) REFERENCES `invoice` (`idInvoice`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customer_due
-- ----------------------------
INSERT INTO `customer_due` VALUES ('1', '1', '1', '260', '0');
INSERT INTO `customer_due` VALUES ('2', '2', '2', '260', '0');
INSERT INTO `customer_due` VALUES ('3', '2', '3', '390', '0');
INSERT INTO `customer_due` VALUES ('4', '1', '4', '650', '0');
INSERT INTO `customer_due` VALUES ('5', '1', '5', '240', '0');
INSERT INTO `customer_due` VALUES ('6', '1', '6', '390', '0');
INSERT INTO `customer_due` VALUES ('7', '1', '7', '340', '0');
INSERT INTO `customer_due` VALUES ('8', '1', '7', '340', '0');
INSERT INTO `customer_due` VALUES ('9', '1', '8', '558', '0');
INSERT INTO `customer_due` VALUES ('10', '2', '9', '405', '0');
INSERT INTO `customer_due` VALUES ('11', '1', '10', '720', '0');

-- ----------------------------
-- Table structure for `c_retun_items`
-- ----------------------------
DROP TABLE IF EXISTS `c_retun_items`;
CREATE TABLE `c_retun_items` (
  `idC_Retun_Items` int(11) NOT NULL AUTO_INCREMENT,
  `reason` varchar(450) DEFAULT NULL,
  `qty` double DEFAULT NULL,
  `C_Returns_idC_Returns` int(11) NOT NULL,
  `Products_idProducts` int(11) NOT NULL,
  PRIMARY KEY (`idC_Retun_Items`),
  KEY `fk_C_Retun_Items_C_Returns1` (`C_Returns_idC_Returns`),
  KEY `fk_C_Retun_Items_Products1` (`Products_idProducts`),
  CONSTRAINT `fk_C_Retun_Items_C_Returns1` FOREIGN KEY (`C_Returns_idC_Returns`) REFERENCES `c_returns` (`idC_Returns`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_C_Retun_Items_Products1` FOREIGN KEY (`Products_idProducts`) REFERENCES `products` (`idProducts`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of c_retun_items
-- ----------------------------
INSERT INTO `c_retun_items` VALUES ('1', 'nooo', '1', '1', '1');

-- ----------------------------
-- Table structure for `c_returns`
-- ----------------------------
DROP TABLE IF EXISTS `c_returns`;
CREATE TABLE `c_returns` (
  `idC_Returns` int(11) NOT NULL AUTO_INCREMENT,
  `Invoice_idInvoice` int(11) NOT NULL,
  `dateTime` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idC_Returns`),
  KEY `fk_C_Returns_Invoice1` (`Invoice_idInvoice`),
  CONSTRAINT `fk_C_Returns_Invoice1` FOREIGN KEY (`Invoice_idInvoice`) REFERENCES `invoice` (`idInvoice`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of c_returns
-- ----------------------------
INSERT INTO `c_returns` VALUES ('1', '1', '2016-07-17');

-- ----------------------------
-- Table structure for `discount`
-- ----------------------------
DROP TABLE IF EXISTS `discount`;
CREATE TABLE `discount` (
  `idDiscount` int(11) NOT NULL AUTO_INCREMENT,
  `value` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDiscount`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of discount
-- ----------------------------
INSERT INTO `discount` VALUES ('1', '0', '1');
INSERT INTO `discount` VALUES ('2', '10', '1');
INSERT INTO `discount` VALUES ('3', '5', '1');

-- ----------------------------
-- Table structure for `grn`
-- ----------------------------
DROP TABLE IF EXISTS `grn`;
CREATE TABLE `grn` (
  `GRN_id` int(11) NOT NULL AUTO_INCREMENT,
  `Supplier_idSupplier` int(11) NOT NULL,
  `dateTime` varchar(45) DEFAULT NULL,
  `totalAmount` double DEFAULT NULL,
  `Payment_Type` int(11) NOT NULL,
  PRIMARY KEY (`GRN_id`),
  KEY `fk_Products_has_Supplier_Supplier1` (`Supplier_idSupplier`),
  KEY `fk_GRN_Payment_Type1` (`Payment_Type`),
  CONSTRAINT `fk_GRN_Payment_Type1` FOREIGN KEY (`Payment_Type`) REFERENCES `payment_type` (`idPayment_Type`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Products_has_Supplier_Supplier1` FOREIGN KEY (`Supplier_idSupplier`) REFERENCES `supplier` (`idSupplier`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of grn
-- ----------------------------
INSERT INTO `grn` VALUES ('33', '2', '2016-07-11', '1464', '1');
INSERT INTO `grn` VALUES ('34', '2', '2016-07-20', '1000', '1');
INSERT INTO `grn` VALUES ('35', '1', '2016-07-20', '420', '1');
INSERT INTO `grn` VALUES ('36', '1', '2016-07-22', '1200', '1');
INSERT INTO `grn` VALUES ('37', '2', '2016-07-22', '1488', '1');
INSERT INTO `grn` VALUES ('38', '1', '2016-07-22', '360', '1');
INSERT INTO `grn` VALUES ('39', '2', '2016-07-23', '5620', '1');
INSERT INTO `grn` VALUES ('40', '2', '2016-07-23', '900', '1');
INSERT INTO `grn` VALUES ('41', '1', '2016-07-23', '3700', '1');
INSERT INTO `grn` VALUES ('42', '1', '2016-07-25', '636', '1');
INSERT INTO `grn` VALUES ('43', '2', '2016-07-25', '100', '1');
INSERT INTO `grn` VALUES ('44', '1', '2016-07-25', '1300', '1');
INSERT INTO `grn` VALUES ('45', '2', '2016-07-25', '48', '1');
INSERT INTO `grn` VALUES ('46', '2', '2016-07-25', '2350', '1');
INSERT INTO `grn` VALUES ('47', '2', '2016-07-25', '2300', '1');
INSERT INTO `grn` VALUES ('48', '1', '2016-07-25', '1100', '2');
INSERT INTO `grn` VALUES ('49', '2', '2016-07-25', '250', '1');
INSERT INTO `grn` VALUES ('52', '1', '2016-07-25', '384', '1');
INSERT INTO `grn` VALUES ('53', '2', '2016-07-25', '1005', '1');
INSERT INTO `grn` VALUES ('54', '2', '2016-07-25', '350', '2');
INSERT INTO `grn` VALUES ('55', '2', '2016-07-31', '500', '1');

-- ----------------------------
-- Table structure for `grn_credit`
-- ----------------------------
DROP TABLE IF EXISTS `grn_credit`;
CREATE TABLE `grn_credit` (
  `idGrnCredit` int(11) NOT NULL AUTO_INCREMENT,
  `dateTime` varchar(45) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `isPaid` int(11) DEFAULT NULL,
  `GRN_GRN_id` int(11) NOT NULL,
  PRIMARY KEY (`idGrnCredit`),
  KEY `fk_Grn_Credit_GRN1` (`GRN_GRN_id`),
  CONSTRAINT `fk_Grn_Credit_GRN1` FOREIGN KEY (`GRN_GRN_id`) REFERENCES `grn` (`GRN_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of grn_credit
-- ----------------------------

-- ----------------------------
-- Table structure for `grn_item`
-- ----------------------------
DROP TABLE IF EXISTS `grn_item`;
CREATE TABLE `grn_item` (
  `idGRN_Item` int(11) NOT NULL AUTO_INCREMENT,
  `GRN_GRN_id` int(11) NOT NULL,
  `Products_idProducts` int(11) NOT NULL,
  `unitPrice` double DEFAULT NULL,
  `qty` double DEFAULT NULL,
  `subTotal` double DEFAULT NULL,
  `sellingPrice` double DEFAULT NULL,
  `stock_idstock` int(11) NOT NULL,
  PRIMARY KEY (`idGRN_Item`),
  KEY `fk_GRN_Item_GRN1` (`GRN_GRN_id`),
  KEY `fk_GRN_Item_Products1` (`Products_idProducts`),
  KEY `fk_GRN_Item_stock1_idx` (`stock_idstock`),
  CONSTRAINT `fk_GRN_Item_GRN1` FOREIGN KEY (`GRN_GRN_id`) REFERENCES `grn` (`GRN_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_GRN_Item_Products1` FOREIGN KEY (`Products_idProducts`) REFERENCES `products` (`idProducts`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_GRN_Item_stock1` FOREIGN KEY (`stock_idstock`) REFERENCES `stock` (`idstock`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of grn_item
-- ----------------------------
INSERT INTO `grn_item` VALUES ('44', '33', '1', '122', '12', '1464', '130', '43');
INSERT INTO `grn_item` VALUES ('45', '34', '1', '100', '10', '1000', '120', '44');
INSERT INTO `grn_item` VALUES ('46', '35', '1', '35', '12', '420', '50', '45');
INSERT INTO `grn_item` VALUES ('47', '36', '4', '100', '12', '1200', '110', '46');
INSERT INTO `grn_item` VALUES ('48', '37', '2', '24', '12', '288', '30', '47');
INSERT INTO `grn_item` VALUES ('49', '37', '3', '100', '12', '1200', '120', '48');
INSERT INTO `grn_item` VALUES ('50', '38', '5', '30', '12', '360', '36', '49');
INSERT INTO `grn_item` VALUES ('51', '39', '1', '120', '10', '1200', '130', '50');
INSERT INTO `grn_item` VALUES ('52', '39', '6', '340', '13', '4420', '350', '51');
INSERT INTO `grn_item` VALUES ('53', '40', '2', '12', '75', '900', '15', '52');
INSERT INTO `grn_item` VALUES ('54', '41', '4', '74', '50', '3700', '80', '53');
INSERT INTO `grn_item` VALUES ('55', '42', '2', '30', '10', '300', '35', '54');
INSERT INTO `grn_item` VALUES ('56', '42', '4', '28', '12', '336', '30', '55');
INSERT INTO `grn_item` VALUES ('57', '43', '4', '10', '10', '100', '20', '56');
INSERT INTO `grn_item` VALUES ('58', '44', '3', '100', '13', '1300', '125', '57');
INSERT INTO `grn_item` VALUES ('59', '45', '6', '12', '4', '48', '132', '58');
INSERT INTO `grn_item` VALUES ('60', '46', '1', '235', '10', '2350', '250', '59');
INSERT INTO `grn_item` VALUES ('61', '47', '1', '230', '10', '2300', '250', '60');
INSERT INTO `grn_item` VALUES ('62', '48', '1', '110', '10', '1100', '125', '61');
INSERT INTO `grn_item` VALUES ('63', '49', '5', '25', '10', '250', '30', '62');
INSERT INTO `grn_item` VALUES ('64', '52', '2', '12', '32', '384', '15', '63');
INSERT INTO `grn_item` VALUES ('65', '53', '2', '67', '15', '1005', '80', '64');
INSERT INTO `grn_item` VALUES ('66', '54', '1', '10', '10', '100', '18', '65');
INSERT INTO `grn_item` VALUES ('67', '54', '1', '25', '10', '250', '30', '66');
INSERT INTO `grn_item` VALUES ('68', '55', '2', '50', '10', '500', '55', '67');

-- ----------------------------
-- Table structure for `invoice`
-- ----------------------------
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice` (
  `idInvoice` int(11) NOT NULL AUTO_INCREMENT,
  `Customer_idCustomer` int(11) DEFAULT NULL,
  `dateTime` varchar(45) DEFAULT NULL,
  `totalAmount` double DEFAULT NULL,
  `Payment_Type_idPayment_Type` int(11) NOT NULL,
  `Discount_idDiscount` int(11) NOT NULL,
  PRIMARY KEY (`idInvoice`),
  KEY `fk_Invoice_Customer1` (`Customer_idCustomer`),
  KEY `fk_Invoice_Payment_Type1` (`Payment_Type_idPayment_Type`),
  KEY `fk_Invoice_Discount1` (`Discount_idDiscount`),
  CONSTRAINT `fk_Invoice_Customer1` FOREIGN KEY (`Customer_idCustomer`) REFERENCES `customer` (`idCustomer`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Invoice_Discount1` FOREIGN KEY (`Discount_idDiscount`) REFERENCES `discount` (`idDiscount`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Invoice_Payment_Type1` FOREIGN KEY (`Payment_Type_idPayment_Type`) REFERENCES `payment_type` (`idPayment_Type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of invoice
-- ----------------------------
INSERT INTO `invoice` VALUES ('1', '1', '2016-07-17', '260', '1', '1');
INSERT INTO `invoice` VALUES ('2', '2', '2016-07-20', '260', '1', '1');
INSERT INTO `invoice` VALUES ('3', '2', '2016-07-20', '390', '1', '1');
INSERT INTO `invoice` VALUES ('4', '1', '2016-07-20', '650', '1', '1');
INSERT INTO `invoice` VALUES ('5', '1', '2016-07-20', '240', '1', '1');
INSERT INTO `invoice` VALUES ('6', '1', '2016-07-22', '390', '1', '1');
INSERT INTO `invoice` VALUES ('7', '1', '2016-07-22', '340', '1', '1');
INSERT INTO `invoice` VALUES ('8', '1', '2016-07-22', '558', '1', '1');
INSERT INTO `invoice` VALUES ('9', '2', '2016-07-25', '405', '1', '1');
INSERT INTO `invoice` VALUES ('10', '1', '2016-07-25', '720', '1', '1');

-- ----------------------------
-- Table structure for `invoice_credit`
-- ----------------------------
DROP TABLE IF EXISTS `invoice_credit`;
CREATE TABLE `invoice_credit` (
  `idInvoice_Credit` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `dateTime` varchar(45) DEFAULT NULL,
  `isPaid` int(11) DEFAULT NULL,
  `Invoice_idInvoice` int(11) NOT NULL,
  PRIMARY KEY (`idInvoice_Credit`),
  KEY `fk_Invoice_Credit_Invoice1` (`Invoice_idInvoice`),
  CONSTRAINT `fk_Invoice_Credit_Invoice1` FOREIGN KEY (`Invoice_idInvoice`) REFERENCES `invoice` (`idInvoice`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of invoice_credit
-- ----------------------------

-- ----------------------------
-- Table structure for `invoice_item`
-- ----------------------------
DROP TABLE IF EXISTS `invoice_item`;
CREATE TABLE `invoice_item` (
  `idInvoice_Item` int(11) NOT NULL AUTO_INCREMENT,
  `Invoice_idInvoice` int(11) NOT NULL,
  `stock_idstock` int(11) NOT NULL,
  `unitPrice` double DEFAULT NULL,
  `qty` double DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  PRIMARY KEY (`idInvoice_Item`),
  KEY `fk_Invoice_Item_Invoice1` (`Invoice_idInvoice`),
  KEY `fk_Invoice_Item_stock1` (`stock_idstock`),
  CONSTRAINT `fk_Invoice_Item_Invoice1` FOREIGN KEY (`Invoice_idInvoice`) REFERENCES `invoice` (`idInvoice`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Invoice_Item_stock1` FOREIGN KEY (`stock_idstock`) REFERENCES `stock` (`idstock`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of invoice_item
-- ----------------------------
INSERT INTO `invoice_item` VALUES ('1', '1', '43', '130', '1', '130');
INSERT INTO `invoice_item` VALUES ('2', '2', '43', '130', '2', '260');
INSERT INTO `invoice_item` VALUES ('3', '3', '43', '130', '3', '390');
INSERT INTO `invoice_item` VALUES ('4', '4', '43', '130', '5', '650');
INSERT INTO `invoice_item` VALUES ('5', '5', '44', '120', '2', '240');
INSERT INTO `invoice_item` VALUES ('6', '6', '44', '120', '2', '240');
INSERT INTO `invoice_item` VALUES ('7', '7', '44', '120', '2', '240');
INSERT INTO `invoice_item` VALUES ('8', '7', '45', '50', '2', '100');
INSERT INTO `invoice_item` VALUES ('9', '8', '46', '110', '2', '198');
INSERT INTO `invoice_item` VALUES ('10', '9', '52', '15', '2', '30');
INSERT INTO `invoice_item` VALUES ('11', '10', '53', '80', '10', '720');

-- ----------------------------
-- Table structure for `payment_type`
-- ----------------------------
DROP TABLE IF EXISTS `payment_type`;
CREATE TABLE `payment_type` (
  `idPayment_Type` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPayment_Type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of payment_type
-- ----------------------------
INSERT INTO `payment_type` VALUES ('1', 'Cash', '1');
INSERT INTO `payment_type` VALUES ('2', 'Check', '1');
INSERT INTO `payment_type` VALUES ('3', 'Debit', '1');

-- ----------------------------
-- Table structure for `products`
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `idProducts` int(11) NOT NULL AUTO_INCREMENT,
  `Products_type_idProducts_type` int(11) NOT NULL,
  `proName` varchar(45) DEFAULT NULL,
  `ProItrmCode` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `barcode` varchar(45) DEFAULT NULL,
  `Discount_idDiscount` int(11) NOT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProducts`),
  KEY `fk_Products_Products_type1` (`Products_type_idProducts_type`),
  KEY `fk_Products_Discount1` (`Discount_idDiscount`),
  CONSTRAINT `fk_Products_Discount1` FOREIGN KEY (`Discount_idDiscount`) REFERENCES `discount` (`idDiscount`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Products_Products_type1` FOREIGN KEY (`Products_type_idProducts_type`) REFERENCES `products_type` (`idProducts_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('1', '2', 'saman', '0001', 'noop', '0123', '1', '1');
INSERT INTO `products` VALUES ('2', '1', 'buiscute', '0002', 'nofff', '02431', '1', '1');
INSERT INTO `products` VALUES ('3', '1', 'Panadol', '0003', 'noo des', '0003', '1', '1');
INSERT INTO `products` VALUES ('4', '2', 'Rice', '0005', 'noo description', '1112453', '2', '1');
INSERT INTO `products` VALUES ('5', '2', 'youghrt', '0006', 'noooo wefwe', '8883', '1', '0');
INSERT INTO `products` VALUES ('6', '3', 'youghrt laky', '0006', 'njknknknk', '32423', '1', '0');

-- ----------------------------
-- Table structure for `products_type`
-- ----------------------------
DROP TABLE IF EXISTS `products_type`;
CREATE TABLE `products_type` (
  `idProducts_type` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idProducts_type`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of products_type
-- ----------------------------
INSERT INTO `products_type` VALUES ('1', 'abc ');
INSERT INTO `products_type` VALUES ('2', 'one');
INSERT INTO `products_type` VALUES ('3', 'nnn');
INSERT INTO `products_type` VALUES ('4', 'Ume');
INSERT INTO `products_type` VALUES ('5', 'A');

-- ----------------------------
-- Table structure for `qtyloosing`
-- ----------------------------
DROP TABLE IF EXISTS `qtyloosing`;
CREATE TABLE `qtyloosing` (
  `idqtyLoosing` int(11) NOT NULL AUTO_INCREMENT,
  `stock_idstock` int(11) NOT NULL,
  `Products_idProducts` int(11) NOT NULL,
  `qty` double DEFAULT NULL,
  `dateTime` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idqtyLoosing`),
  KEY `fk_qtyLoosing_stock1` (`stock_idstock`),
  KEY `fk_qtyLoosing_Products1` (`Products_idProducts`),
  CONSTRAINT `fk_qtyLoosing_Products1` FOREIGN KEY (`Products_idProducts`) REFERENCES `products` (`idProducts`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_qtyLoosing_stock1` FOREIGN KEY (`stock_idstock`) REFERENCES `stock` (`idstock`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of qtyloosing
-- ----------------------------

-- ----------------------------
-- Table structure for `qty_type`
-- ----------------------------
DROP TABLE IF EXISTS `qty_type`;
CREATE TABLE `qty_type` (
  `idQty_Type` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(45) DEFAULT NULL,
  `Status` int(11) DEFAULT NULL,
  PRIMARY KEY (`idQty_Type`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of qty_type
-- ----------------------------
INSERT INTO `qty_type` VALUES ('1', 'kG', '1');
INSERT INTO `qty_type` VALUES ('2', 'G', '1');
INSERT INTO `qty_type` VALUES ('3', 'L', '1');
INSERT INTO `qty_type` VALUES ('4', 'ML', '1');

-- ----------------------------
-- Table structure for `stock`
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `idstock` int(11) NOT NULL AUTO_INCREMENT,
  `Products_idProducts` int(11) NOT NULL,
  `Buying_Price` double DEFAULT NULL,
  `Selling_price` double DEFAULT NULL,
  `qty` double DEFAULT NULL,
  `buyDate` varchar(45) DEFAULT NULL,
  `exdate` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `canloosing` int(11) DEFAULT NULL,
  `Qty_Type_id` int(11) NOT NULL,
  PRIMARY KEY (`idstock`),
  KEY `fk_stock_Products1` (`Products_idProducts`),
  KEY `fk_stock_Qty_Type1_idx` (`Qty_Type_id`),
  CONSTRAINT `fk_stock_Products1` FOREIGN KEY (`Products_idProducts`) REFERENCES `products` (`idProducts`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_stock_Qty_Type1` FOREIGN KEY (`Qty_Type_id`) REFERENCES `qty_type` (`idQty_Type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES ('43', '1', '122', '130', '0', '2016-07-11', '2016-07-27', '4', '0', '0', '0');
INSERT INTO `stock` VALUES ('44', '1', '100', '120', '4', '2016-07-20', '2016-07-30', '4', '0', '0', '0');
INSERT INTO `stock` VALUES ('45', '1', '35', '50', '10', '2016-07-20', '2016-07-30', '4', '0', '1', '0');
INSERT INTO `stock` VALUES ('46', '4', '100', '110', '10', '2016-07-22', '2016-07-30', '4', '10', '1', '0');
INSERT INTO `stock` VALUES ('47', '2', '24', '30', '12', '2016-07-22', '2016-07-31', '4', '0', '0', '0');
INSERT INTO `stock` VALUES ('48', '3', '100', '120', '12', '2016-07-22', '2016-07-31', '4', '0', '1', '0');
INSERT INTO `stock` VALUES ('49', '5', '30', '36', '12', '2016-07-22', '2016-07-31', '4', '0', '0', '0');
INSERT INTO `stock` VALUES ('50', '1', '120', '130', '10', '2016-07-23', '2016-07-30', '4', '10', '1', '0');
INSERT INTO `stock` VALUES ('51', '6', '340', '350', '13', '2016-07-23', '2016-07-30', '4', '0', '1', '0');
INSERT INTO `stock` VALUES ('52', '2', '12', '15', '73', '2016-07-23', '2016-07-31', '4', '0', '1', '0');
INSERT INTO `stock` VALUES ('53', '4', '74', '80', '40', '2016-07-23', '2016-07-30', '4', '0', '1', '0');
INSERT INTO `stock` VALUES ('54', '2', '30', '35', '10', '2016-07-25', '2016-07-31', '4', '0', '0', '0');
INSERT INTO `stock` VALUES ('55', '4', '28', '30', '12', '2016-07-25', '2016-07-31', '4', '0', '0', '0');
INSERT INTO `stock` VALUES ('56', '4', '10', '20', '10', '2016-07-25', '2016-07-30', '4', '0', '0', '0');
INSERT INTO `stock` VALUES ('57', '3', '100', '125', '13', '2016-07-25', '2016-07-30', '4', '0', '0', '0');
INSERT INTO `stock` VALUES ('58', '6', '12', '132', '4', '2016-07-25', '2016-07-30', '4', '0', '0', '0');
INSERT INTO `stock` VALUES ('59', '1', '235', '250', '10', '2016-07-25', '2016-07-31', '4', '0', '0', '0');
INSERT INTO `stock` VALUES ('60', '1', '230', '250', '10', '2016-07-25', '2016-07-31', '4', '0', '0', '0');
INSERT INTO `stock` VALUES ('61', '1', '110', '125', '10', '2016-07-25', '2016-07-30', '4', '0', '0', '0');
INSERT INTO `stock` VALUES ('62', '5', '25', '30', '10', '2016-07-25', '2016-07-29', '4', '0', '0', '0');
INSERT INTO `stock` VALUES ('63', '2', '12', '15', '32', '2016-07-25', '2016-07-31', '4', '0', '0', '0');
INSERT INTO `stock` VALUES ('64', '2', '67', '80', '15', '2016-07-25', '2016-07-31', '4', '0', '0', '0');
INSERT INTO `stock` VALUES ('65', '1', '10', '18', '10', '2016-07-25', '2016-07-31', '4', '0', '0', '0');
INSERT INTO `stock` VALUES ('66', '1', '25', '30', '10', '2016-07-25', '2016-07-31', '4', '0', '0', '0');
INSERT INTO `stock` VALUES ('67', '2', '50', '55', '10', '2016-07-31', '2016-08-31', '1', '0', '1', '1');

-- ----------------------------
-- Table structure for `stockupdated`
-- ----------------------------
DROP TABLE IF EXISTS `stockupdated`;
CREATE TABLE `stockupdated` (
  `idStockUpdated` int(11) NOT NULL AUTO_INCREMENT,
  `reason` varchar(1000) DEFAULT NULL,
  `datetime` varchar(45) DEFAULT NULL,
  `stock_idstock` int(11) NOT NULL,
  PRIMARY KEY (`idStockUpdated`),
  KEY `fk_StockUpdated_stock1` (`stock_idstock`),
  CONSTRAINT `fk_StockUpdated_stock1` FOREIGN KEY (`stock_idstock`) REFERENCES `stock` (`idstock`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of stockupdated
-- ----------------------------
INSERT INTO `stockupdated` VALUES ('1', '', 'Fri Jul 22 13:02:48 IST 2016', '45');
INSERT INTO `stockupdated` VALUES ('2', '', 'Fri Jul 22 13:03:52 IST 2016', '45');

-- ----------------------------
-- Table structure for `supplier`
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `idSupplier` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `lanNo` varchar(45) DEFAULT NULL,
  `Company` varchar(45) DEFAULT NULL,
  `address01` varchar(45) DEFAULT NULL,
  `address02` varchar(45) DEFAULT NULL,
  `address03` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSupplier`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('1', 'abc', 'bhagya@gmail.com', '1234567890', '1234567890', 'bpos', 'no1', 'no2', 'no3', null);
INSERT INTO `supplier` VALUES ('2', 'amal', 'amal@gmail.com', '0987654321', '0987654321', 'eset', 'colombo', 'bolombo 1', 'colombo 3', null);

-- ----------------------------
-- Table structure for `supplierduerecords`
-- ----------------------------
DROP TABLE IF EXISTS `supplierduerecords`;
CREATE TABLE `supplierduerecords` (
  `idDueRecords` int(11) NOT NULL,
  `amount` varchar(45) DEFAULT NULL,
  `Supplier_Due_idSupplier_Due` int(11) NOT NULL,
  `Datetime` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idDueRecords`),
  KEY `fk_SupplierDueRecords_Supplier_Due1_idx` (`Supplier_Due_idSupplier_Due`),
  CONSTRAINT `fk_SupplierDueRecords_Supplier_Due1` FOREIGN KEY (`Supplier_Due_idSupplier_Due`) REFERENCES `supplier_due` (`idSupplier_Due`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of supplierduerecords
-- ----------------------------

-- ----------------------------
-- Table structure for `supplier_due`
-- ----------------------------
DROP TABLE IF EXISTS `supplier_due`;
CREATE TABLE `supplier_due` (
  `idSupplier_Due` int(11) NOT NULL AUTO_INCREMENT,
  `Supplier_idSupplier` int(11) NOT NULL,
  `GRN_GRN_id` int(11) NOT NULL,
  `total` double DEFAULT NULL,
  `dueamount` double DEFAULT NULL,
  PRIMARY KEY (`idSupplier_Due`),
  KEY `fk_Supplier_Due_Supplier1_idx` (`Supplier_idSupplier`),
  KEY `fk_Supplier_Due_GRN1_idx` (`GRN_GRN_id`),
  CONSTRAINT `fk_Supplier_Due_GRN1` FOREIGN KEY (`GRN_GRN_id`) REFERENCES `grn` (`GRN_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Supplier_Due_Supplier1` FOREIGN KEY (`Supplier_idSupplier`) REFERENCES `supplier` (`idSupplier`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of supplier_due
-- ----------------------------
INSERT INTO `supplier_due` VALUES ('1', '2', '33', '1464', '0');
INSERT INTO `supplier_due` VALUES ('2', '2', '34', '1000', '0');
INSERT INTO `supplier_due` VALUES ('3', '1', '35', '420', '0');
INSERT INTO `supplier_due` VALUES ('4', '1', '36', '1200', '0');
INSERT INTO `supplier_due` VALUES ('5', '2', '37', '1488', '0');
INSERT INTO `supplier_due` VALUES ('6', '2', '37', '1488', '0');
INSERT INTO `supplier_due` VALUES ('7', '1', '38', '360', '0');
INSERT INTO `supplier_due` VALUES ('8', '2', '39', '5620', '0');
INSERT INTO `supplier_due` VALUES ('9', '2', '39', '5620', '0');
INSERT INTO `supplier_due` VALUES ('10', '2', '40', '900', '0');
INSERT INTO `supplier_due` VALUES ('11', '1', '41', '3700', '0');
INSERT INTO `supplier_due` VALUES ('12', '1', '42', '636', '0');
INSERT INTO `supplier_due` VALUES ('13', '1', '42', '636', '0');
INSERT INTO `supplier_due` VALUES ('14', '2', '43', '100', '0');
INSERT INTO `supplier_due` VALUES ('15', '1', '44', '1300', '0');
INSERT INTO `supplier_due` VALUES ('16', '2', '45', '48', '0');
INSERT INTO `supplier_due` VALUES ('17', '2', '46', '2350', '0');
INSERT INTO `supplier_due` VALUES ('18', '2', '47', '2300', '0');
INSERT INTO `supplier_due` VALUES ('19', '2', '49', '250', '0');
INSERT INTO `supplier_due` VALUES ('20', '1', '52', '384', '0');
INSERT INTO `supplier_due` VALUES ('21', '2', '53', '1005', '0');
INSERT INTO `supplier_due` VALUES ('22', '2', '54', '350', '0');
INSERT INTO `supplier_due` VALUES ('23', '2', '54', '350', '0');
INSERT INTO `supplier_due` VALUES ('24', '2', '55', '500', '0');

-- ----------------------------
-- Table structure for `s_returns`
-- ----------------------------
DROP TABLE IF EXISTS `s_returns`;
CREATE TABLE `s_returns` (
  `idS_Returns` int(11) NOT NULL AUTO_INCREMENT,
  `dateTime` varchar(45) DEFAULT NULL,
  `GRN_GRN_id` int(11) NOT NULL,
  PRIMARY KEY (`idS_Returns`),
  KEY `fk_S_Returns_GRN1` (`GRN_GRN_id`),
  CONSTRAINT `fk_S_Returns_GRN1` FOREIGN KEY (`GRN_GRN_id`) REFERENCES `grn` (`GRN_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of s_returns
-- ----------------------------
INSERT INTO `s_returns` VALUES ('1', '2016-07-17', '33');

-- ----------------------------
-- Table structure for `s_return_items`
-- ----------------------------
DROP TABLE IF EXISTS `s_return_items`;
CREATE TABLE `s_return_items` (
  `idS_Return_Items` int(11) NOT NULL AUTO_INCREMENT,
  `S_Returns_idS_Returns` int(11) NOT NULL,
  `Products_idProducts` int(11) NOT NULL,
  `qty` double DEFAULT NULL,
  `reson` varchar(450) DEFAULT NULL,
  PRIMARY KEY (`idS_Return_Items`),
  KEY `fk_S_Return_Items_S_Returns1` (`S_Returns_idS_Returns`),
  KEY `fk_S_Return_Items_Products1` (`Products_idProducts`),
  CONSTRAINT `fk_S_Return_Items_Products1` FOREIGN KEY (`Products_idProducts`) REFERENCES `products` (`idProducts`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_S_Return_Items_S_Returns1` FOREIGN KEY (`S_Returns_idS_Returns`) REFERENCES `s_returns` (`idS_Returns`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of s_return_items
-- ----------------------------
INSERT INTO `s_return_items` VALUES ('1', '1', '1', '1', 'damage');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `lanNo` varchar(45) DEFAULT NULL,
  `Gender` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'bhagya', 'perera', 'bhagyaperera142@gmail.com', '0719877863', '4523625763', 'Female');
INSERT INTO `user` VALUES ('2', 'Amal', 'Perera', 'amal@gmail.com', '0715766685', '0385766775', 'Male');

-- ----------------------------
-- Table structure for `usertype_has_window`
-- ----------------------------
DROP TABLE IF EXISTS `usertype_has_window`;
CREATE TABLE `usertype_has_window` (
  `UserType_Has_Page` int(11) NOT NULL AUTO_INCREMENT,
  `User_Type_idUser_Type` int(11) NOT NULL,
  `User_Window_idUser_Page` int(11) NOT NULL,
  PRIMARY KEY (`UserType_Has_Page`),
  KEY `fk_UserType_Has_Page_User_Type1` (`User_Type_idUser_Type`),
  KEY `fk_UserType_Has_Page_User_Window1` (`User_Window_idUser_Page`),
  CONSTRAINT `fk_UserType_Has_Page_User_Type1` FOREIGN KEY (`User_Type_idUser_Type`) REFERENCES `user_type` (`idUser_Type`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_UserType_Has_Page_User_Window1` FOREIGN KEY (`User_Window_idUser_Page`) REFERENCES `user_window` (`idUser_Page`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of usertype_has_window
-- ----------------------------

-- ----------------------------
-- Table structure for `user_login`
-- ----------------------------
DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login` (
  `idUser_Login` int(11) NOT NULL AUTO_INCREMENT,
  `User_name` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `User_id` int(11) NOT NULL,
  `User_Type` int(11) NOT NULL,
  PRIMARY KEY (`idUser_Login`),
  KEY `fk_User_Login_User` (`User_id`),
  KEY `fk_User_Login_User_Type1` (`User_Type`),
  CONSTRAINT `fk_User_Login_User` FOREIGN KEY (`User_id`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_Login_User_Type1` FOREIGN KEY (`User_Type`) REFERENCES `user_type` (`idUser_Type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_login
-- ----------------------------
INSERT INTO `user_login` VALUES ('1', 'bhagya', '1995', '1', '1', '1');
INSERT INTO `user_login` VALUES ('2', 'amalperera', 'amal123', '1', '2', '2');

-- ----------------------------
-- Table structure for `user_type`
-- ----------------------------
DROP TABLE IF EXISTS `user_type`;
CREATE TABLE `user_type` (
  `idUser_Type` int(11) NOT NULL AUTO_INCREMENT,
  `Type_Name` varchar(45) DEFAULT NULL,
  `Status` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUser_Type`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_type
-- ----------------------------
INSERT INTO `user_type` VALUES ('1', 'Admin', '1');
INSERT INTO `user_type` VALUES ('2', 'User', '1');

-- ----------------------------
-- Table structure for `user_window`
-- ----------------------------
DROP TABLE IF EXISTS `user_window`;
CREATE TABLE `user_window` (
  `idUser_Page` int(11) NOT NULL AUTO_INCREMENT,
  `Page_Name` varchar(45) DEFAULT NULL,
  `Url` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUser_Page`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_window
-- ----------------------------
