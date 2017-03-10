/*
SELECT name, language, percentage FROM countries
JOIN languages ON languages.country_code = countries.code AND language = "Slovene"
ORDER BY percentage DESC

SELECT countries.name, COUNT(cities.name) AS cities FROM cities
JOIN countries ON cities.country_code = countries.code
GROUP BY countries.name
ORDER BY COUNT(cities.name) desc

SELECT cities.name, cities.population from cities
JOIN countries ON countries.code = cities.country_code
WHERE countries.name="Mexico" AND cities.population >= 500000

SELECT countries.name, languages.language, languages.percentage from languages

JOIN countries ON countries.code = languages.country_code

WHERE percentage > 89.0

ORDER BY percentage DESC

SELECT name, surface_area, population FROM countries

WHERE surface_area < 501 AND population > 100000

SELECT name, government_form, capital, life_expectancy FROM countries

WHERE government_form="Constitutional Monarchy" AND capital > 200 AND life_expectancy >75
SELECT countries.name, cities.name, cities.district, countries.population FROM countries

JOIN cities on cities.country_code = countries.code

WHERE cities.district="Buenos Aires" AND countries.population > 500000

SELECT region, COUNT(name) AS countries FROM countries

GROUP BY region

ORDER BY countries DESC
*/