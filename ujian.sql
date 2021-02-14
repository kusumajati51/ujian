SELECT CompanyName,
    City,
    ProductName
FROM Products p
    JOIN Suppliers s on s.SupplierID = p.SupplierID
    JOIN Categories c on p.CategorieID = c.CategorieID
WHERE c.CategorieName = "Seafood"
    AND i2.check_out < 15
    AND s.City = "Jakarata"
    OR s.City = "Bogor";