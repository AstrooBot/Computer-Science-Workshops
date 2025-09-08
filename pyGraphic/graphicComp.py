import seaborn as sns
import matplotlib.pyplot as plt
import pandas as pd

coordenadas_list = [
    [(10, 9555), (100, 1392878), (1000, 157400352), (10000, -1758732460), (20_000, 1686175404), (30_000, -2066281268), (40_000, -1228820832)],   # Grupo A
    [(10, 105), (100, 1207), (1000, 12588), (10000, 124362), (20_000, 24903), (30_000, 374068), (40_000, 498358)],   # Grupo B
    [(10, 574), (100, 10850), (1000, 155757), (10000, 1948283), (20_000, 4151299), (30_000, 6460168), (40_000, 8805992)], # Grupo C
    [(10, 2187), (100, 19439), (1000,211403), (10000, 4891223), (20_000, 16121793), (30_000, 15991151), (40_000, 23396078)],   # Grupo B
    [(10, 5565), (100, 729028), (1000, 79235166), (10000, -856918889), (20_000, 944320023), (30_000, 1244144610), (40_000, -373454323)] # Grupo C
]

nombres_conjuntos = ['Burbuja', 'Insercion', 'Merge', 'Quick', 'Seleccion']

def graficar_con_lineas(coord_list, nombres=None):
    if not coord_list:
        print("No hay coordenadas para graficar.")
        return

    data_total = []
    for idx, coords in enumerate(coord_list):
        if not coords:
            continue
        x_vals, y_vals = zip(*coords)
        grupo = nombres[idx] if nombres and idx < len(nombres) else f'Grupo {idx+1}'
        for x, y in zip(x_vals, y_vals):
            data_total.append({'x': x, 'y': y, 'grupo': grupo})

    df = pd.DataFrame(data_total)

    plt.figure(figsize=(8, 6))

    sns.lineplot(data=df, x='x', y='y', hue='grupo', palette='tab10', marker='o')

    plt.title("Gráfica de Candidatos vs Cantidad Comparaciones Orden inverso")
    plt.xlabel("Cantidad de Candidatos")
    plt.ylabel("Comparaciones")
    plt.legend(title="Grupo")
    plt.tight_layout()
    plt.show()

if __name__ == "__main__":
    graficar_con_lineas(coordenadas_list, nombres_conjuntos)
