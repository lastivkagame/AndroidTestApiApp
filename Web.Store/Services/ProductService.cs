using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Web.Store.Data;
using Web.Store.Data.Entities;
using Web.Store.Repositories;

namespace Web.Store.Services
{
    public class ProductService : IRepository<Product>
    {
        private bool disposed = false;
        private readonly EFAppContext _context;

        public ProductService(EFAppContext appContext)
        {
            _context = appContext;
        }

        public async Task CreateAsync(Product item)
        {
            await _context.Products.AddAsync(item);
        }

        public async Task DeleteAsync(int id)
        {
            Product product = await _context.Products.FindAsync(id);
            if (product != null)
            {
                _context.Products.Remove(product);
            }
        }

        public async Task<Product> GetAsync(int id)
        {
            return await _context.Products.FindAsync(id);
        }

        public IEnumerable<Product> GetAll()
        {
            return _context.Products.ToList();
        }

        public async Task SaveAsync()
        {
            await _context.SaveChangesAsync();
        }

        protected virtual void Dispose(bool disposing)
        {
            if (!this.disposed)
            {
                if (disposing)
                {
                    _context.Dispose();
                }
            }
            this.disposed = true;
        }
        public void Dispose()
        {
            Dispose(true);
            GC.SuppressFinalize(this);
        }

        async Task<Product> IRepository<Product>.GetAsync(int id)
        {
            return await _context.Products.FindAsync(id);
        }

        async Task IRepository<Product>.CreateAsync(Product item)
        {
            await _context.Products.AddAsync(item);
        }

        public void Update(Product item)
        {
            _context.Entry(item).State = Microsoft.EntityFrameworkCore.EntityState.Modified;
        }
    }
}
