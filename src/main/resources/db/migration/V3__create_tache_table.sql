CREATE TABLE tache(
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    libelle_tach VARCHAR(50),
    date DATE,
    heure TIME,
    statut_tach BOOLEAN,
    utilisateur_id INT,
    categorie_id INT,

    FOREIGN KEY (utilisateur_id) REFERENCES utilisateur(id),
    FOREIGN KEY (categorie_id) REFERENCES categorie(id)
)