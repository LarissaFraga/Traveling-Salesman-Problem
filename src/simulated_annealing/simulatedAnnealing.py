import os, math, random

def calculaDistancia(cidade1, cidade2):
    return math.sqrt((cidade1[0]-cidade2[0])**2+(cidade1[1]-cidade2[1])**2)

def distanciaTotal(cidade, arrCidades):
    distancia=0
    for i in range(len(cidade)-1):
        distancia += calculaDistancia(arrCidades[cidade[i]],arrCidades[cidade[i+1]])
    distancia += calculaDistancia(arrCidades[cidade[-1]],arrCidades[cidade[0]])
    return distancia

def main():
    # lista os arquivos de entrada que terminam com .txt
    pasta = "arquivos/"
    quantidadesSolucoes = int(input('Digite a quantidade de soluções por arquivo: '))
    caminhos = [os.path.join(pasta, nome) for nome in os.listdir(pasta)]
    arquivos = [arquivo for arquivo in caminhos if os.path.isfile(arquivo)]    
    arquivos_txt = [arquivo for arquivo in arquivos if arquivo.lower().endswith(".txt")]
    
    # arquivos de saida serao armazenados neste vetor
    saida = []
    
    # percorrer os arquivos
    for arquivo in arquivos_txt:    
        #abre o arquivo 
        with open(arquivo) as f:
            linhas = f.readlines()
            
    #grava a lista em um novo arquivo
    diretorio_saida = 'arquivo_saida/'
    #os.mkdir(diretorio_saida)
    arquivo1 = open('meuarquivo.txt', 'w')

if __name__ == '__main__':
   main()
