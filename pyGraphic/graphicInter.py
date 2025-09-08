import seaborn as sns
import matplotlib.pyplot as plt
import pandas as pd

coordenadas_list = [
    [(10, 2951), (100, 367345), (1000, 39618538), (10000, -421230392), (20_000, -1628477103), (30_000, 728609277), (40_000, 2130327577)],   # Grupo A
    [(10, 2951), (100, 367345), (1000, 39618538), (10000, -421230392), (20_000, -1628477103), (30_000, 728609277), (40_000, 2130327577)],   # Grupo B
    [(10, 720), (100, 12448), (1000, 172451), (10000, 2107462), (20_000, 446952), (30_000, 6957092), (40_000, 9442892)], # Grupo C
    [(10, 158), (100, 4361), (1000,57318), (10000, 647772), (20_000, 1434416), (30_000, 3142522), (40_000, 3809797)],   # Grupo B
    [(10, 101), (100, 1199), (1000, 12579), (10000, 124352), (20_000, 249023), (30_000, 374056), (40_000, 498348)] # Grupo C
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

    plt.title("Gráfica de Candidatos vs Intercambios Orden casi ordenado")
    plt.xlabel("Cantidad de candidatos")
    plt.ylabel("Cantidad de Intercambios")
    plt.legend(title="Grupo")
    plt.tight_layout()
    plt.show()

if __name__ == "__main__":
    graficar_con_lineas(coordenadas_list, nombres_conjuntos)