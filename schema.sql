CREATE TABLE IF NOT EXISTS AgePrediction (
    id INT AUTO_INCREMENT PRIMARY KEY,
    gender VARCHAR(10),
    height_cm FLOAT,
    weight_kg FLOAT,
    blood_pressure_systolic INT,
    blood_pressure_diastolic INT,
    cholesterol_level FLOAT,
    bmi FLOAT,
    blood_glucose_level FLOAT,
    bone_density FLOAT,
    vision_sharpness FLOAT,
    hearing_ability_db FLOAT,
    physical_activity_level VARCHAR(20),
    smoking_status VARCHAR(20),
    alcohol_consumption VARCHAR(20),
    diet VARCHAR(20),
    chronic_diseases VARCHAR(50),
    medication_use VARCHAR(50),
    family_history VARCHAR(50),
    cognitive_function VARCHAR(50),
    mental_health_status VARCHAR(50),
    sleep_patterns VARCHAR(50),
    stress_levels VARCHAR(50),
    pollution_exposure VARCHAR(50),
    sun_exposure VARCHAR(50),
    education_level VARCHAR(50),
    income_level VARCHAR(50)
);
