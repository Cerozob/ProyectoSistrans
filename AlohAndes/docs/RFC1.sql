--Ganancias de empresas
SELECT NOMB_EMP, SUM(valor) as Ganancias
FROM CONTRATO c , (SELECT NIT as N, NOMBRE NOMb_EMP FROM EMPRESA) e           
WHERE  e.N = c.nit_empresa AND 
        (EXTRACT(YEAR FROM fecha_inicio)) = EXTRACT(YEAR FROM CURRENT_DATE) AND
        (EXTRACT(MONTH FROM fecha_inicio)) <= EXTRACT(MONTH FROM CURRENT_DATE) AND
        (EXTRACT(DAY FROM fecha_inicio)) <= EXTRACT(DAY FROM CURRENT_DATE)
GROUP BY nit_empresa, nomb_emp;

-- Ganancias de Personas naturales
SELECT NOMB_per, SUM(valor) as Ganancias
FROM CONTRATO c , (SELECT identificacion as N, NOMBRE NOMb_PER FROM persona_natural ) e     
WHERE  e.N = c.cedulapersonanatural AND 
        (EXTRACT(YEAR FROM fecha_inicio)) = EXTRACT(YEAR FROM CURRENT_DATE) AND
        (EXTRACT(MONTH FROM fecha_inicio)) <= EXTRACT(MONTH FROM CURRENT_DATE) AND
        (EXTRACT(DAY FROM fecha_inicio)) <= EXTRACT(DAY FROM CURRENT_DATE)
GROUP BY nit_empresa, nomb_per;

--todo junto
SELECT * FROM ( SELECT NOMB_EMP, SUM(valor) as Ganancias
FROM CONTRATO c , (SELECT NIT as N, NOMBRE NOMb_EMP FROM EMPRESA ) e           
WHERE  e.N = c.nit_empresa AND 
        (EXTRACT(YEAR FROM fecha_inicio)) = EXTRACT(YEAR FROM CURRENT_DATE) AND
        (EXTRACT(MONTH FROM fecha_inicio)) <= EXTRACT(MONTH FROM CURRENT_DATE) AND
        (EXTRACT(DAY FROM fecha_inicio)) <= EXTRACT(DAY FROM CURRENT_DATE)
GROUP BY nit_empresa, nomb_emp ) FULL JOIN  (SELECT NOMB_per, SUM(valor) as Ganancias
FROM CONTRATO c , (SELECT identificacion as N, NOMBRE NOMb_PER FROM persona_natural ) e     
WHERE  e.N = c.cedulapersonanatural AND 
        (EXTRACT(YEAR FROM fecha_inicio)) = EXTRACT(YEAR FROM CURRENT_DATE) AND
        (EXTRACT(MONTH FROM fecha_inicio)) <= EXTRACT(MONTH FROM CURRENT_DATE) AND
        (EXTRACT(DAY FROM fecha_inicio)) <= EXTRACT(DAY FROM CURRENT_DATE)
GROUP BY nit_empresa, nomb_per) on nomb_per = nomb_emp;
