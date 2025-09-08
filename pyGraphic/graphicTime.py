import seaborn as sns
import matplotlib.pyplot as plt
import pandas as pd

coordenadas_list = [
    [(10, 1161), (100, 1484), (1000, 1457), (10000, 37091), (20_000, 141160), (30_000, 320341), (40_000, 567321)],   # Grupo A
    [(10, 1161), (100, 1477), (1000, 1296), (10000, 11714), (20_000, 38349), (30_000, 91635), (40_000, 152192)],   # Grupo B
    [(10, 1160), (100, 1471), (1000, 1194), (10000, 2156), (20_000, 297), (30_000, 2321), (40_000, 2287)], # Grupo C
    [(10, 1161), (100, 1471), (1000,1196), (10000, 2174), (20_000, 336), (30_000, 2353), (40_000, 2332)],   # Grupo B
    [(10, 1161), (100, 1474), (1000, 1224), (10000, 4441), (20_000,9294 ), (30_000, 22595), (40_000, 38245)] # Grupo C
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

    sns.set(style="whitegrid")
    plt.figure(figsize=(8, 6))

    sns.lineplot(data=df, x='x', y='y', hue='grupo', palette='tab10', marker='o')

    plt.title("Gráfica de Candidatos vs Tiempo. Orden inverso")
    plt.xlabel("Cantidad de Candidatos")
    plt.ylabel("Tiempo (ms)")
    plt.legend(title="Grupo")
    plt.tight_layout()
    plt.show()

if __name__ == "__main__":
    graficar_con_lineas(coordenadas_list, nombres_conjuntos)
