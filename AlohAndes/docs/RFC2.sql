--RFC2
SELECT h.Nombre, C FROM (select nombre, idhospedaje from hospedaje) h JOIN ( SELECT * 
fROM (SELECT idhospedaje,COUNT(*) C
        FROM CONTRATO 
        GROUP BY idhospedaje 
        ORDER BY C DESC)
WHERE ROWNUM <= 20) f ON h.idhospedaje = f.idhospedaje;